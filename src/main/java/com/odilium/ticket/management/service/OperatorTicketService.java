package com.odilium.ticket.management.service;

import com.odilium.ticket.management.cache.entities.TicketInformation;
import com.odilium.ticket.management.entities.OperatorTicket;
import com.odilium.ticket.management.helpers.TicketManagerHelper;
import com.odilium.ticket.management.kafka.interfaces.MongoChannel;
import com.odilium.ticket.management.kafka.interfaces.RedisChannel;
import com.odilium.ticket.management.mongo.entities.TicketLogs;
import com.odilium.ticket.management.repository.OperatorTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OperatorTicketService {

    private OperatorTicketRepository operatorTicketRepository;
    private MongoChannel mongoChannel;
    private RedisChannel redisChannel;

    @Autowired
    public OperatorTicketService(OperatorTicketRepository operatorTicketRepository, MongoChannel mongoChannel, RedisChannel redisChannel) {
        this.operatorTicketRepository = operatorTicketRepository;
        this.mongoChannel = mongoChannel;
        this.redisChannel = redisChannel;
    }

    public void createOperatorTicket(OperatorTicket operatorTicket){
        try {
            operatorTicket.setTransactionID(TicketManagerHelper.generateTransactionID());
            operatorTicketRepository.save(operatorTicket);
            TicketLogs ticketLogs = TicketManagerHelper.createTicketLogsObjectFromOperatorTicket(operatorTicket);
            mongoChannel.output().send(MessageBuilder.withPayload(ticketLogs).build());
            String ticketId = operatorTicket.getTicketID();
            String dateOfEscalation = operatorTicket.getTicketIssuedDateTime();
            TicketInformation ticketInformation = TicketManagerHelper.createCacheTicketInformation(ticketId, dateOfEscalation);
            redisChannel.output().send(MessageBuilder.withPayload(ticketInformation).build());
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
