package com.odilium.ticket.management.request.object;

public class TicketFollowUpRequest {

    private String complaintTicketID;
    private String consumerPhoneNumber;
    private String escalationDateTime;
    private String agentNotes;
    private String ticketIssuedDateTime;
    private String agentName;

    public TicketFollowUpRequest() {
    }

    public TicketFollowUpRequest(String complaintTicketID, String consumerPhoneNumber, String escalationDateTime,
                                 String agentNotes, String ticketIssuedDateTime, String agentName) {
        this.complaintTicketID = complaintTicketID;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.escalationDateTime = escalationDateTime;
        this.agentNotes = agentNotes;
        this.ticketIssuedDateTime = ticketIssuedDateTime;
        this.agentName = agentName;
    }

    public String getComplaintTicketID() {
        return complaintTicketID;
    }

    public void setComplaintTicketID(String complaintTicketID) {
        this.complaintTicketID = complaintTicketID;
    }

    public String getConsumerPhoneNumber() {
        return consumerPhoneNumber;
    }

    public void setConsumerPhoneNumber(String consumerPhoneNumber) {
        this.consumerPhoneNumber = consumerPhoneNumber;
    }

    public String getEscalationDateTime() {
        return escalationDateTime;
    }

    public void setEscalationDateTime(String escalationDateTime) {
        this.escalationDateTime = escalationDateTime;
    }

    public String getAgentNotes() {
        return agentNotes;
    }

    public void setAgentNotes(String agentNotes) {
        this.agentNotes = agentNotes;
    }

    public String getTicketIssuedDateTime() {
        return ticketIssuedDateTime;
    }

    public void setTicketIssuedDateTime(String ticketIssuedDateTime) {
        this.ticketIssuedDateTime = ticketIssuedDateTime;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    @Override
    public String toString() {
        return "TicketFollowUpRequest{" +
                "complaintTicketID='" + complaintTicketID + '\'' +
                ", consumerPhoneNumber='" + consumerPhoneNumber + '\'' +
                ", escalationDateTime='" + escalationDateTime + '\'' +
                ", agentNotes='" + agentNotes + '\'' +
                ", ticketIssuedDateTime='" + ticketIssuedDateTime + '\'' +
                ", agentName='" + agentName + '\'' +
                '}';
    }
}
