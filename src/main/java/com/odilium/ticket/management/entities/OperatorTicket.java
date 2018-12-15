package com.odilium.ticket.management.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "OperatorTicketDetail", catalog = "Complaint_Test", schema = "dbo")
public class OperatorTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "OperatorName", length = 50)
    private String operatorName;
    @Column(name = "TicketID", length = 17)
    private String ticketID;
    @Column(name = "TicketIssuedDateTime", length = 50)
    private String ticketIssuedDateTime;
    @Column(name = "ConsumerTitle", length = 15)
    private String consumerTitle;
    @Column(name = "ConsumerName", length = 50)
    private String consumerName;
    @Column(name = "ConsumerSurname", length = 50)
    private String consumerSurname;
    @Column(name = "ConsumerPhoneNumber", length = 11)
    private String consumerPhoneNumber;
    @Column(name = "ConsumerAlternatePhoneNumber", length = 11)
    private String consumerAlternatePhoneNumber;
    @Column(name = "ConsumerCity", length = 50)
    private String consumerCity;
    @Column(name = "ConsumerLGA", length = 50)
    private String consumerLGA;
    @Column(name = "ConsumerState", length = 50)
    private String consumerState;
    @Column(name = "ConsumerZone", length = 50)
    private String consumerZone;
    @Column(name = "OperatorAgentName", length = 50)
    private String operatorAgentName;
    @Column(name = "ComplaintCode", length = 255)
    private String complaintCode;
    @Column(name = "ComplaintDescription", length = 2000)
    private String complaintDescription;
    @Column(name = "ComplaintStatus", length = 20)
    private String complaintStatus;
    @Column(name = "ComplaintSLA", length = 50)
    private String complaintSLA;
    @Column(name = "ResolutionDateTime", length = 50)
    private String resolutionDateTime;
    @Column(name = "ImportDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date importDateTime;
    @Column(name = "Exported", length = 3)
    private String exported;
    @Column(name = "FileNameID", length = 100)
    private String fileNameID;
    @Column(name = "NCCAgentTicketID", length = 17)
    private String nCCAgentTicketID;
    @Id
    @Basic(optional = false)
    @Column(name = "TransactionID", nullable = false)
    private Long transactionID;

    public OperatorTicket() {
    }

    public OperatorTicket(String operatorName, String ticketID, String ticketIssuedDateTime, String consumerTitle,
                          String consumerName, String consumerSurname, String consumerPhoneNumber,
                          String consumerAlternatePhoneNumber, String consumerCity, String consumerLGA,
                          String consumerState, String consumerZone, String operatorAgentName, String complaintCode,
                          String complaintDescription, String complaintStatus, String complaintSLA, String resolutionDateTime,
                          Date importDateTime, String exported, String fileNameID, String nCCAgentTicketID) {
        this.operatorName = operatorName;
        this.ticketID = ticketID;
        this.ticketIssuedDateTime = ticketIssuedDateTime;
        this.consumerTitle = consumerTitle;
        this.consumerName = consumerName;
        this.consumerSurname = consumerSurname;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
        this.consumerCity = consumerCity;
        this.consumerLGA = consumerLGA;
        this.consumerState = consumerState;
        this.consumerZone = consumerZone;
        this.operatorAgentName = operatorAgentName;
        this.complaintCode = complaintCode;
        this.complaintDescription = complaintDescription;
        this.complaintStatus = complaintStatus;
        this.complaintSLA = complaintSLA;
        this.resolutionDateTime = resolutionDateTime;
        this.importDateTime = importDateTime;
        this.exported = exported;
        this.fileNameID = fileNameID;
        this.nCCAgentTicketID = nCCAgentTicketID;
    }

    public OperatorTicket(String operatorName, String ticketID, String ticketIssuedDateTime, String consumerTitle,
                          String consumerName, String consumerSurname, String consumerPhoneNumber,
                          String consumerAlternatePhoneNumber, String consumerCity, String consumerLGA,
                          String consumerState, String consumerZone, String operatorAgentName, String complaintCode,
                          String complaintDescription, String complaintStatus, String complaintSLA, String resolutionDateTime,
                          Date importDateTime, String exported, String fileNameID, String nCCAgentTicketID, Long transactionID) {
        this.operatorName = operatorName;
        this.ticketID = ticketID;
        this.ticketIssuedDateTime = ticketIssuedDateTime;
        this.consumerTitle = consumerTitle;
        this.consumerName = consumerName;
        this.consumerSurname = consumerSurname;
        this.consumerPhoneNumber = consumerPhoneNumber;
        this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
        this.consumerCity = consumerCity;
        this.consumerLGA = consumerLGA;
        this.consumerState = consumerState;
        this.consumerZone = consumerZone;
        this.operatorAgentName = operatorAgentName;
        this.complaintCode = complaintCode;
        this.complaintDescription = complaintDescription;
        this.complaintStatus = complaintStatus;
        this.complaintSLA = complaintSLA;
        this.resolutionDateTime = resolutionDateTime;
        this.importDateTime = importDateTime;
        this.exported = exported;
        this.fileNameID = fileNameID;
        this.nCCAgentTicketID = nCCAgentTicketID;
        this.transactionID = transactionID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketIssuedDateTime() {
        return ticketIssuedDateTime;
    }

    public void setTicketIssuedDateTime(String ticketIssuedDateTime) {
        this.ticketIssuedDateTime = ticketIssuedDateTime;
    }

    public String getConsumerTitle() {
        return consumerTitle;
    }

    public void setConsumerTitle(String consumerTitle) {
        this.consumerTitle = consumerTitle;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerSurname() {
        return consumerSurname;
    }

    public void setConsumerSurname(String consumerSurname) {
        this.consumerSurname = consumerSurname;
    }

    public String getConsumerPhoneNumber() {
        return consumerPhoneNumber;
    }

    public void setConsumerPhoneNumber(String consumerPhoneNumber) {
        this.consumerPhoneNumber = consumerPhoneNumber;
    }

    public String getConsumerAlternatePhoneNumber() {
        return consumerAlternatePhoneNumber;
    }

    public void setConsumerAlternatePhoneNumber(String consumerAlternatePhoneNumber) {
        this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
    }

    public String getConsumerCity() {
        return consumerCity;
    }

    public void setConsumerCity(String consumerCity) {
        this.consumerCity = consumerCity;
    }

    public String getConsumerLGA() {
        return consumerLGA;
    }

    public void setConsumerLGA(String consumerLGA) {
        this.consumerLGA = consumerLGA;
    }

    public String getConsumerState() {
        return consumerState;
    }

    public void setConsumerState(String consumerState) {
        this.consumerState = consumerState;
    }

    public String getConsumerZone() {
        return consumerZone;
    }

    public void setConsumerZone(String consumerZone) {
        this.consumerZone = consumerZone;
    }

    public String getOperatorAgentName() {
        return operatorAgentName;
    }

    public void setOperatorAgentName(String operatorAgentName) {
        this.operatorAgentName = operatorAgentName;
    }

    public String getComplaintCode() {
        return complaintCode;
    }

    public void setComplaintCode(String complaintCode) {
        this.complaintCode = complaintCode;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public String getComplaintSLA() {
        return complaintSLA;
    }

    public void setComplaintSLA(String complaintSLA) {
        this.complaintSLA = complaintSLA;
    }

    public String getResolutionDateTime() {
        return resolutionDateTime;
    }

    public void setResolutionDateTime(String resolutionDateTime) {
        this.resolutionDateTime = resolutionDateTime;
    }

    public Date getImportDateTime() {
        return importDateTime;
    }

    public void setImportDateTime(Date importDateTime) {
        this.importDateTime = importDateTime;
    }

    public String getExported() {
        return exported;
    }

    public void setExported(String exported) {
        this.exported = exported;
    }

    public String getFileNameID() {
        return fileNameID;
    }

    public void setFileNameID(String fileNameID) {
        this.fileNameID = fileNameID;
    }

    public String getnCCAgentTicketID() {
        return nCCAgentTicketID;
    }

    public void setnCCAgentTicketID(String nCCAgentTicketID) {
        this.nCCAgentTicketID = nCCAgentTicketID;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @Override
    public String toString() {
        return "OperatorTicket{" +
                "operatorName='" + operatorName + '\'' +
                ", ticketID='" + ticketID + '\'' +
                ", ticketIssuedDateTime='" + ticketIssuedDateTime + '\'' +
                ", consumerTitle='" + consumerTitle + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", consumerSurname='" + consumerSurname + '\'' +
                ", consumerPhoneNumber='" + consumerPhoneNumber + '\'' +
                ", consumerAlternatePhoneNumber='" + consumerAlternatePhoneNumber + '\'' +
                ", consumerCity='" + consumerCity + '\'' +
                ", consumerLGA='" + consumerLGA + '\'' +
                ", consumerState='" + consumerState + '\'' +
                ", consumerZone='" + consumerZone + '\'' +
                ", operatorAgentName='" + operatorAgentName + '\'' +
                ", complaintCode='" + complaintCode + '\'' +
                ", complaintDescription='" + complaintDescription + '\'' +
                ", complaintStatus='" + complaintStatus + '\'' +
                ", complaintSLA='" + complaintSLA + '\'' +
                ", resolutionDateTime='" + resolutionDateTime + '\'' +
                ", importDateTime=" + importDateTime +
                ", exported='" + exported + '\'' +
                ", fileNameID='" + fileNameID + '\'' +
                ", nCCAgentTicketID='" + nCCAgentTicketID + '\'' +
                ", transactionID=" + transactionID +
                '}';
    }
}
