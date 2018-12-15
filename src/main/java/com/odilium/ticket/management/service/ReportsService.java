package com.odilium.ticket.management.service;

import com.odilium.ticket.management.helpers.TicketManagerHelper;
import com.odilium.ticket.management.mongo.entities.TicketLogs;
import com.odilium.ticket.management.repository.TicketLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ReportsService {

    private TicketLogsRepository ticketLogsRepository;

    private static Logger logger = Logger.getLogger("ReportsService");

    @Autowired
    public ReportsService(TicketLogsRepository ticketLogsRepository) {
        this.ticketLogsRepository = ticketLogsRepository;
    }




    public Map<String, Long> groupCountAllTicketLogsByComplaintStatus(String startDateString, String endDateString){
        Date startDate = TicketManagerHelper.generateDateTime(startDateString);
        Date endDate = TicketManagerHelper.generateDateTime(endDateString);
        return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                .collect(Collectors.groupingBy(TicketLogs::getComplaintStatus, Collectors.counting()));
    }

    public Map<String, Long> groupCountAllTicketLogsByStateOfOrigin(String startDateString, String endDateString){
        Date startDate = TicketManagerHelper.generateDateTime(startDateString);
        Date endDate = TicketManagerHelper.generateDateTime(endDateString);
        return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                .collect(Collectors.groupingBy(TicketLogs::getConsumerState, Collectors.counting()));
    }

    public Map<String, Long> groupCountAllTicketLogsByZone(String startDateString, String endDateString){
        Date startDate = TicketManagerHelper.generateDateTime(startDateString);
        Date endDate = TicketManagerHelper.generateDateTime(endDateString);
        return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                .collect(Collectors.groupingBy(TicketLogs::getConsumerZone, Collectors.counting()));
    }

    public Map<String, Long> groupCountAllTicketLogsByComplaintCode(String startDateString, String endDateString){
        Date startDate = TicketManagerHelper.generateDateTime(startDateString);
        Date endDate = TicketManagerHelper.generateDateTime(endDateString);
        return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                .collect(Collectors.groupingBy(TicketLogs::getComplaintCode, Collectors.counting()));
    }

    public Map<String, Map<String, Long>> groupCountAllTicketLogsByOperatorByStatus(String startDateString, String endDateString){
        try {
            Date startDate = TicketManagerHelper.generateDateTime(startDateString);
            Date endDate = TicketManagerHelper.generateDateTime(endDateString);
            return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                    .collect(Collectors.groupingBy(TicketLogs::getServiceProvider, Collectors.groupingBy(TicketLogs::getComplaintStatus,
                            Collectors.counting())));
        }catch (Exception ex){
            logger.severe(ex.getMessage());
        }
        return null;
    }

    public Map<String, Map<String, Long>> groupCountAllTicketLogsByStatePerServiceProvider(String startDateString, String endDateString){
        Date startDate = TicketManagerHelper.generateDateTime(startDateString);
        Date endDate = TicketManagerHelper.generateDateTime(endDateString);
        try {

            return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                    .collect(Collectors.groupingBy(TicketLogs::getConsumerState, Collectors.groupingBy(TicketLogs::getServiceProvider,
                            Collectors.counting())));
        }catch (Exception ex){
            logger.severe(ex.getMessage());

        }
        return null;
    }


    public Map<String, Long> groupCountAllTicketLogsByStatus(){
        try {
            Date startDate = TicketManagerHelper.generateMidnightDate();
            Date endDate = new Date();
            return ticketLogsRepository.findByTicketIssuedDateTimeBetween(startDate, endDate)
                    .collect(Collectors.groupingBy(TicketLogs::getComplaintStatus,
                            Collectors.counting()));
        }catch (Exception ex){
            logger.severe(ex.getMessage());

        }
        return null;
    }
}
