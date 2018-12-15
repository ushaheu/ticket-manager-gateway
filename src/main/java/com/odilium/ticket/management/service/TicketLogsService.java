package com.odilium.ticket.management.service;

import com.odilium.ticket.management.mongo.entities.TicketLogs;
import com.odilium.ticket.management.repository.TicketLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketLogsService {

    private TicketLogsRepository ticketLogsRepository;

    @Autowired
    public TicketLogsService(TicketLogsRepository ticketLogsRepository) {
        this.ticketLogsRepository = ticketLogsRepository;
    }

    public List<TicketLogs> findTicketLogsByTicketIDOrPhoneNumber(String ticketID, String phoneNumber){
        List<TicketLogs> ticketLogsList = ticketLogsRepository.findByTicketIDOrConsumerPhoneNumber(ticketID, phoneNumber);
        return ticketLogsList;
    }

    public void updateTicketStatus(String ticketID, String status){
        try {
            List<TicketLogs> ticketLogsList = ticketLogsRepository.findByticketID(ticketID);
            if(!ticketLogsList.isEmpty()){
                for(TicketLogs ticketLogs : ticketLogsList) {
                    ticketLogs.setComplaintStatus(status);
                    ticketLogsRepository.save(ticketLogs);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }
}
