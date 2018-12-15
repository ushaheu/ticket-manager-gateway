package com.odilium.ticket.management.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AgentFollowUpTicketDetail", catalog = "Complaint_Test", schema = "dbo")
public class TicketFollowUp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "AgentName", length = 50)
    private String agentName;
    @Column(name = "AgentDateTime", length = 50)
    private String agentDateTime;
    @Column(name = "AgentNotes", length = 2000)
    private String agentNotes;
    @Column(name = "AgentCRMReleaseDateTime", length = 50)
    private String agentCRMReleaseDateTime;
    @Column(name = "ComplaintTicketID", length = 17)
    private String complaintTicketID;
    @Column(name = "ConsumerPhoneNumber", length = 11)
    private String consumerPhoneNumber;
    @Column(name = "ImportDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date importDateTime;
    @Column(name = "FileNameID", length = 100)
    private String fileNameID;
    @Id
    @Basic(optional = false)
    @Column(name = "TransactionID", nullable = false)
    private Long transactionID;

    public TicketFollowUp() {
    }

    public TicketFollowUp(String agentName, String agentDateTime, String agentNotes, String agentCRMReleaseDateTime,
                          String complaintTicketID, String consumerPhoneNumber, Date importDateTime, String fileNameID) {
        this.agentName = agentName;
        this.agentDateTime = agentDateTime;
        this.agentNotes = agentNotes;
        this.agentCRMReleaseDateTime = agentCRMReleaseDateTime;
        this.complaintTicketID = complaintTicketID;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.importDateTime = importDateTime;
        this.fileNameID = fileNameID;
    }

    public TicketFollowUp(String agentName, String agentDateTime, String agentNotes, String agentCRMReleaseDateTime,
                          String complaintTicketID, String consumerPhoneNumber, Date importDateTime, String fileNameID,
                          Long transactionID) {
        this.agentName = agentName;
        this.agentDateTime = agentDateTime;
        this.agentNotes = agentNotes;
        this.agentCRMReleaseDateTime = agentCRMReleaseDateTime;
        this.complaintTicketID = complaintTicketID;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.importDateTime = importDateTime;
        this.fileNameID = fileNameID;
        this.transactionID = transactionID;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentDateTime() {
        return agentDateTime;
    }

    public void setAgentDateTime(String agentDateTime) {
        this.agentDateTime = agentDateTime;
    }

    public String getAgentNotes() {
        return agentNotes;
    }

    public void setAgentNotes(String agentNotes) {
        this.agentNotes = agentNotes;
    }

    public String getAgentCRMReleaseDateTime() {
        return agentCRMReleaseDateTime;
    }

    public void setAgentCRMReleaseDateTime(String agentCRMReleaseDateTime) {
        this.agentCRMReleaseDateTime = agentCRMReleaseDateTime;
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

    public Date getImportDateTime() {
        return importDateTime;
    }

    public void setImportDateTime(Date importDateTime) {
        this.importDateTime = importDateTime;
    }

    public String getFileNameID() {
        return fileNameID;
    }

    public void setFileNameID(String fileNameID) {
        this.fileNameID = fileNameID;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public String toString() {
        return "TicketFollowUp{" +
                "agentName='" + agentName + '\'' +
                ", agentDateTime='" + agentDateTime + '\'' +
                ", agentNotes='" + agentNotes + '\'' +
                ", agentCRMReleaseDateTime='" + agentCRMReleaseDateTime + '\'' +
                ", complaintTicketID='" + complaintTicketID + '\'' +
                ", consumerPhoneNumber='" + consumerPhoneNumber + '\'' +
                ", importDateTime=" + importDateTime +
                ", fileNameID='" + fileNameID + '\'' +
                ", transactionID=" + transactionID +
                '}';
    }
}
