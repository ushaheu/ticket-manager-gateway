package com.odilium.ticket.management.service;

import com.odilium.ticket.management.entities.AgentTicket;
import com.odilium.ticket.management.entities.TicketFollowUp;
import com.odilium.ticket.management.helpers.TicketManagerHelper;
import com.odilium.ticket.management.mongo.entities.TicketLogs;
import com.odilium.ticket.management.kafka.interfaces.MongoChannel;
import com.odilium.ticket.management.repository.AgentTicketRepository;
import com.odilium.ticket.management.repository.TicketFollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentTicketService {

    private AgentTicketRepository agentTicketRepository;
    private MongoChannel mongoChannel;
    private TicketFollowUpRepository ticketFollowUpRepository;

    @Autowired
    public AgentTicketService(AgentTicketRepository agentTicketRepository, TicketFollowUpRepository ticketFollowUpRepository, MongoChannel mongoChannel) {
        this.agentTicketRepository = agentTicketRepository;
        this.ticketFollowUpRepository = ticketFollowUpRepository;
        this.mongoChannel = mongoChannel;
    }

    public void createAgentTicket(AgentTicket agentTicket){
        try {
            agentTicket.setTransactionID(TicketManagerHelper.generateTransactionID());
            agentTicketRepository.save(agentTicket);
            TicketLogs ticketLogs = TicketManagerHelper.createTicketLogsObjectFromAgentTicket(agentTicket);
            TicketFollowUp ticketFollowUp = TicketManagerHelper.createTicketFollowUpFromAgentTicket(agentTicket);
            ticketFollowUp.setTransactionID(TicketManagerHelper.generateTransactionID());
            ticketFollowUpRepository.save(ticketFollowUp);
            mongoChannel.output().send(MessageBuilder.withPayload(ticketLogs).build());
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public void updateTicketStatus(String ticketID, String status){
        try {
            List<AgentTicket> agentTicketList = agentTicketRepository.findByComplaintTicketID(ticketID);
            if(!agentTicketList.isEmpty()){
                for(AgentTicket agentTicket : agentTicketList) {
                    agentTicket.setComplaintStatus(status);
                    agentTicketRepository.save(agentTicket);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }


}
