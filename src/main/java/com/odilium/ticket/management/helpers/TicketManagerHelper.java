package com.odilium.ticket.management.helpers;

import com.odilium.ticket.management.cache.entities.TicketInformation;
import com.odilium.ticket.management.entities.AgentTicket;
import com.odilium.ticket.management.entities.OperatorTicket;
import com.odilium.ticket.management.entities.TicketFollowUp;
import com.odilium.ticket.management.mongo.entities.TicketLogs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TicketManagerHelper {

    public static TicketLogs createTicketLogsObjectFromAgentTicket(AgentTicket agentTicket){
        TicketLogs ticketLogs = new TicketLogs();
        ticketLogs.setComplaintCode(agentTicket.getComplaintCode());
        ticketLogs.setComplaintDescription(agentTicket.getComplaintDescription());
        ticketLogs.setComplaintSLA(agentTicket.getComplaintSLA());
        ticketLogs.setComplaintStatus(agentTicket.getComplaintStatus());
        ticketLogs.setConsumerAlternatePhoneNumber(agentTicket.getConsumerAlternatePhoneNumber());
        ticketLogs.setConsumerCity(agentTicket.getConsumerCity());
        ticketLogs.setConsumerLGA(agentTicket.getConsumerLGA());
        ticketLogs.setConsumerName(agentTicket.getConsumerName());
        ticketLogs.setConsumerPhoneNumber(agentTicket.getConsumerPhoneNumber());
        ticketLogs.setConsumerState(agentTicket.getConsumerState());
        ticketLogs.setConsumerSurname(agentTicket.getConsumerSurname());
        ticketLogs.setConsumerTitle(agentTicket.getConsumerTitle());
        ticketLogs.setConsumerZone(agentTicket.getConsumerZone());
        ticketLogs.setOperatorAgentName(agentTicket.getAgentName());
        ticketLogs.setResolutionDateTime(agentTicket.getResolutionDateTime().toString());
        ticketLogs.setTicketID(agentTicket.getComplaintTicketID());
        ticketLogs.setTicketIssuedDateTime(agentTicket.getEscalationDateTime());
        ticketLogs.setServiceProvider(agentTicket.getServiceProvider());
        ticketLogs.setCallDuration(agentTicket.getCallDuration());
        ticketLogs.setCallInitiatedDateTime(agentTicket.getCallInitiatedDateTime());
        ticketLogs.setCallQueueWaitTime(agentTicket.getCallQueueWaitTime());
        ticketLogs.setCallTerminatedDateTime(agentTicket.getCallTerminatedDateTime());
        ticketLogs.setIvrCallTime(agentTicket.getIvrCallTime());
        return ticketLogs;
    }

    public static TicketLogs createTicketLogsObjectFromOperatorTicket(OperatorTicket operatorTicket){
        TicketLogs ticketLogs = new TicketLogs();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yyyy h:m:s a");
            ticketLogs.setTicketIssuedDateTime(simpleDateFormat.parse(operatorTicket.getTicketIssuedDateTime()));
        }catch (Exception ex){

        }
        ticketLogs.setTicketID(operatorTicket.getTicketID());
        ticketLogs.setResolutionDateTime(operatorTicket.getResolutionDateTime());
        ticketLogs.setOperatorAgentName(operatorTicket.getOperatorAgentName());
        ticketLogs.setConsumerZone(operatorTicket.getConsumerZone());
        ticketLogs.setConsumerTitle(operatorTicket.getConsumerTitle());
        ticketLogs.setConsumerSurname(operatorTicket.getConsumerSurname());
        ticketLogs.setConsumerState(operatorTicket.getConsumerState());
        ticketLogs.setConsumerPhoneNumber(operatorTicket.getConsumerPhoneNumber());
        ticketLogs.setConsumerName(operatorTicket.getConsumerName());
        ticketLogs.setConsumerLGA(operatorTicket.getConsumerLGA());
        ticketLogs.setConsumerCity(operatorTicket.getConsumerCity());
        ticketLogs.setConsumerAlternatePhoneNumber(operatorTicket.getConsumerAlternatePhoneNumber());
        ticketLogs.setComplaintStatus(operatorTicket.getComplaintStatus());
        ticketLogs.setComplaintSLA(operatorTicket.getComplaintSLA());
        ticketLogs.setComplaintDescription(operatorTicket.getComplaintDescription());
        ticketLogs.setComplaintCode(operatorTicket.getComplaintCode());
        ticketLogs.setServiceProvider(operatorTicket.getOperatorName());
        ticketLogs.setCallDuration(0d);
        ticketLogs.setCallInitiatedDateTime(null);
        ticketLogs.setCallQueueWaitTime(0d);
        ticketLogs.setCallTerminatedDateTime(null);
        ticketLogs.setIvrCallTime(0d);
        return ticketLogs;
    }

    public static TicketFollowUp createTicketFollowUpFromAgentTicket(AgentTicket agentTicket){
        TicketFollowUp ticketFollowUp = new TicketFollowUp();
        ticketFollowUp.setAgentName(agentTicket.getsPAgentName());
        ticketFollowUp.setAgentNotes(agentTicket.getAgentNotes());
        ticketFollowUp.setComplaintTicketID(agentTicket.getComplaintTicketID());
        ticketFollowUp.setConsumerPhoneNumber(agentTicket.getConsumerPhoneNumber());
        ticketFollowUp.setAgentCRMReleaseDateTime(generateTodaysDate());;
        ticketFollowUp.setAgentDateTime(generateTodaysDate());
        return ticketFollowUp;
    }

    public static String generateTodaysDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = new Date();
        return simpleDateFormat.format(today);
    }

    public static Date generateDateTime(String dateString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    public static TicketInformation createCacheTicketInformation(String ticketId, String dateOfEscalation){
        TicketInformation ticketInformation = new TicketInformation();
        ticketInformation.setTicketId(ticketId);
        ticketInformation.setDateOfEscalation(dateOfEscalation);
        return ticketInformation;
    }

    public static Long generateTransactionID(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSS");
        LocalDateTime date = LocalDateTime.now();
        return Long.parseLong(dateTimeFormatter.format(date));
    }

    public static Date generateMidnightDate(){
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date.getTime();
    }
}
