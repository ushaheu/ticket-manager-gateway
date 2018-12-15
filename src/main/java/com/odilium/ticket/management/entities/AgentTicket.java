package com.odilium.ticket.management.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "AgentTicketDetail", catalog = "Complaint_Test", schema = "dbo")
public class AgentTicket implements Serializable {
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
        @Column(name = "SPAgentName", length = 50)
        private String sPAgentName;
        @Column(name = "ComplaintCode", length = 255)
        private String complaintCode;
        @Column(name = "ComplaintDescription", length = 2000)
        private String complaintDescription;
        @Column(name = "ComplaintStatus", length = 20)
        private String complaintStatus;
        @Column(name = "ComplaintSLA", length = 50)
        private String complaintSLA;
        @Column(name = "ImportDateTime")
        @Temporal(TemporalType.TIMESTAMP)
        private Date importDateTime;
        @Column(name = "EscalationDateTime")
        @Temporal(TemporalType.TIMESTAMP)
        private Date escalationDateTime;
        @Column(name = "ServiceProvider", length = 50)
        private String serviceProvider;
        @Column(name = "ActionTakenByAgent", length = 255)
        private String actionTakenByAgent;
        @Column(name = "ReportingOfficer", length = 50)
        private String reportingOfficer;
        @Column(name = "SubCategory", length = 150)
        private String subCategory;
        @Column(name = "SLABreachStatus")
        private Boolean sLABreachStatus;
        @Column(name = "Remarks", length = 2000)
        private String remarks;
        @Column(name = "Exported", length = 3)
        private String exported;
        @Column(name = "FileNameID", length = 100)
        private String fileNameID;
        @Column(name = "ResolutionDateTime")
        @Temporal(TemporalType.TIMESTAMP)
        private Date resolutionDateTime;
        @Column(name = "ResolutionNotes", length = 2000)
        private String resolutionNotes;
        @Id
        @Basic(optional = false)
        @Column(name = "TransactionID", nullable = false)
        private Long transactionID;
        @Column(name = "ProviderTicketid", nullable = false)
        private String providerTicketId;
        @Column(name = "call_initiated_date_time", nullable = false)
        private Date callInitiatedDateTime;
        @Column(name = "call_terminated_date_time", nullable = false)
        private Date callTerminatedDateTime;
        @Column(name = "call_queue_wait_time", nullable = false)
        private Double callQueueWaitTime;
        @Column(name = "call_duration", nullable = false)
        private Double callDuration;
        @Column(name = "call_ivr_time", nullable = false)
        private Double ivrCallTime;

        public AgentTicket() {
        }

        public AgentTicket(String agentName, String agentDateTime, String agentNotes, String agentCRMReleaseDateTime,
                           String complaintTicketID, String consumerTitle, String consumerName, String consumerSurname,
                           String consumerPhoneNumber, String consumerAlternatePhoneNumber, String consumerCity,
                           String consumerLGA, String consumerState, String consumerZone, String sPAgentName,
                           String complaintCode, String complaintDescription, String complaintStatus, String complaintSLA,
                           Date importDateTime, Date escalationDateTime, String serviceProvider, String actionTakenByAgent,
                           String reportingOfficer, String subCategory, Boolean sLABreachStatus, String remarks,
                           String exported, String fileNameID, Date resolutionDateTime, String resolutionNotes,
                           String providerTicketId, Date callInitiatedDateTime, Date callTerminatedDateTime,
                           Double callQueueWaitTime, Double callDuration, Double ivrCallTime) {
                this.agentName = agentName;
                this.agentDateTime = agentDateTime;
                this.agentNotes = agentNotes;
                this.agentCRMReleaseDateTime = agentCRMReleaseDateTime;
                this.complaintTicketID = complaintTicketID;
                this.consumerTitle = consumerTitle;
                this.consumerName = consumerName;
                this.consumerSurname = consumerSurname;
                this.consumerPhoneNumber = consumerPhoneNumber;
                this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
                this.consumerCity = consumerCity;
                this.consumerLGA = consumerLGA;
                this.consumerState = consumerState;
                this.consumerZone = consumerZone;
                this.sPAgentName = sPAgentName;
                this.complaintCode = complaintCode;
                this.complaintDescription = complaintDescription;
                this.complaintStatus = complaintStatus;
                this.complaintSLA = complaintSLA;
                this.importDateTime = importDateTime;
                this.escalationDateTime = escalationDateTime;
                this.serviceProvider = serviceProvider;
                this.actionTakenByAgent = actionTakenByAgent;
                this.reportingOfficer = reportingOfficer;
                this.subCategory = subCategory;
                this.sLABreachStatus = sLABreachStatus;
                this.remarks = remarks;
                this.exported = exported;
                this.fileNameID = fileNameID;
                this.resolutionDateTime = resolutionDateTime;
                this.resolutionNotes = resolutionNotes;
                this.providerTicketId = providerTicketId;
                this.callInitiatedDateTime = callInitiatedDateTime;
                this.callTerminatedDateTime = callTerminatedDateTime;
                this.callQueueWaitTime = callQueueWaitTime;
                this.callDuration = callDuration;
                this.ivrCallTime = ivrCallTime;
        }

        public AgentTicket(String agentName, String agentDateTime, String agentNotes, String agentCRMReleaseDateTime,
                           String complaintTicketID, String consumerTitle, String consumerName, String consumerSurname,
                           String consumerPhoneNumber, String consumerAlternatePhoneNumber, String consumerCity,
                           String consumerLGA, String consumerState, String consumerZone, String sPAgentName,
                           String complaintCode, String complaintDescription, String complaintStatus, String complaintSLA,
                           Date importDateTime, Date escalationDateTime, String serviceProvider, String actionTakenByAgent,
                           String reportingOfficer, String subCategory, Boolean sLABreachStatus, String remarks,
                           String exported, String fileNameID, Date resolutionDateTime, String resolutionNotes,
                           Long transactionID, String providerTicketId, Date callInitiatedDateTime, Date callTerminatedDateTime,
                           Double callQueueWaitTime, Double callDuration, Double ivrCallTime) {
                this.agentName = agentName;
                this.agentDateTime = agentDateTime;
                this.agentNotes = agentNotes;
                this.agentCRMReleaseDateTime = agentCRMReleaseDateTime;
                this.complaintTicketID = complaintTicketID;
                this.consumerTitle = consumerTitle;
                this.consumerName = consumerName;
                this.consumerSurname = consumerSurname;
                this.consumerPhoneNumber = consumerPhoneNumber;
                this.consumerAlternatePhoneNumber = consumerAlternatePhoneNumber;
                this.consumerCity = consumerCity;
                this.consumerLGA = consumerLGA;
                this.consumerState = consumerState;
                this.consumerZone = consumerZone;
                this.sPAgentName = sPAgentName;
                this.complaintCode = complaintCode;
                this.complaintDescription = complaintDescription;
                this.complaintStatus = complaintStatus;
                this.complaintSLA = complaintSLA;
                this.importDateTime = importDateTime;
                this.escalationDateTime = escalationDateTime;
                this.serviceProvider = serviceProvider;
                this.actionTakenByAgent = actionTakenByAgent;
                this.reportingOfficer = reportingOfficer;
                this.subCategory = subCategory;
                this.sLABreachStatus = sLABreachStatus;
                this.remarks = remarks;
                this.exported = exported;
                this.fileNameID = fileNameID;
                this.resolutionDateTime = resolutionDateTime;
                this.resolutionNotes = resolutionNotes;
                this.transactionID = transactionID;
                this.providerTicketId = providerTicketId;
                this.callInitiatedDateTime = callInitiatedDateTime;
                this.callTerminatedDateTime = callTerminatedDateTime;
                this.callQueueWaitTime = callQueueWaitTime;
                this.callDuration = callDuration;
                this.ivrCallTime = ivrCallTime;
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

        public String getsPAgentName() {
                return sPAgentName;
        }

        public void setsPAgentName(String sPAgentName) {
                this.sPAgentName = sPAgentName;
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

        public Date getImportDateTime() {
                return importDateTime;
        }

        public void setImportDateTime(Date importDateTime) {
                this.importDateTime = importDateTime;
        }

        public Date getEscalationDateTime() {
                return escalationDateTime;
        }

        public void setEscalationDateTime(Date escalationDateTime) {
                this.escalationDateTime = escalationDateTime;
        }

        public String getServiceProvider() {
                return serviceProvider;
        }

        public void setServiceProvider(String serviceProvider) {
                this.serviceProvider = serviceProvider;
        }

        public String getActionTakenByAgent() {
                return actionTakenByAgent;
        }

        public void setActionTakenByAgent(String actionTakenByAgent) {
                this.actionTakenByAgent = actionTakenByAgent;
        }

        public String getReportingOfficer() {
                return reportingOfficer;
        }

        public void setReportingOfficer(String reportingOfficer) {
                this.reportingOfficer = reportingOfficer;
        }

        public String getSubCategory() {
                return subCategory;
        }

        public void setSubCategory(String subCategory) {
                this.subCategory = subCategory;
        }

        public Boolean getsLABreachStatus() {
                return sLABreachStatus;
        }

        public void setsLABreachStatus(Boolean sLABreachStatus) {
                this.sLABreachStatus = sLABreachStatus;
        }

        public String getRemarks() {
                return remarks;
        }

        public void setRemarks(String remarks) {
                this.remarks = remarks;
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

        public Date getResolutionDateTime() {
                return resolutionDateTime;
        }

        public void setResolutionDateTime(Date resolutionDateTime) {
                this.resolutionDateTime = resolutionDateTime;
        }

        public String getResolutionNotes() {
                return resolutionNotes;
        }

        public void setResolutionNotes(String resolutionNotes) {
                this.resolutionNotes = resolutionNotes;
        }

        public Long getTransactionID() {
                return transactionID;
        }

        public void setTransactionID(Long transactionID) {
                this.transactionID = transactionID;
        }

        public String getProviderTicketId() {
                return providerTicketId;
        }

        public void setProviderTicketId(String providerTicketId) {
                this.providerTicketId = providerTicketId;
        }

        public Date getCallInitiatedDateTime() {
                return callInitiatedDateTime;
        }

        public void setCallInitiatedDateTime(Date callInitiatedDateTime) {
                this.callInitiatedDateTime = callInitiatedDateTime;
        }

        public Date getCallTerminatedDateTime() {
                return callTerminatedDateTime;
        }

        public void setCallTerminatedDateTime(Date callTerminatedDateTime) {
                this.callTerminatedDateTime = callTerminatedDateTime;
        }

        public Double getCallQueueWaitTime() {
                return callQueueWaitTime;
        }

        public void setCallQueueWaitTime(Double callQueueWaitTime) {
                this.callQueueWaitTime = callQueueWaitTime;
        }

        public Double getCallDuration() {
                return callDuration;
        }

        public void setCallDuration(Double callDuration) {
                this.callDuration = callDuration;
        }

        public Double getIvrCallTime() {
                return ivrCallTime;
        }

        public void setIvrCallTime(Double ivrCallTime) {
                this.ivrCallTime = ivrCallTime;
        }

        @Override
        public String toString() {
                return "AgentTicket{" +
                        "agentName='" + agentName + '\'' +
                        ", agentDateTime='" + agentDateTime + '\'' +
                        ", agentNotes='" + agentNotes + '\'' +
                        ", agentCRMReleaseDateTime='" + agentCRMReleaseDateTime + '\'' +
                        ", complaintTicketID='" + complaintTicketID + '\'' +
                        ", consumerTitle='" + consumerTitle + '\'' +
                        ", consumerName='" + consumerName + '\'' +
                        ", consumerSurname='" + consumerSurname + '\'' +
                        ", consumerPhoneNumber='" + consumerPhoneNumber + '\'' +
                        ", consumerAlternatePhoneNumber='" + consumerAlternatePhoneNumber + '\'' +
                        ", consumerCity='" + consumerCity + '\'' +
                        ", consumerLGA='" + consumerLGA + '\'' +
                        ", consumerState='" + consumerState + '\'' +
                        ", consumerZone='" + consumerZone + '\'' +
                        ", sPAgentName='" + sPAgentName + '\'' +
                        ", complaintCode='" + complaintCode + '\'' +
                        ", complaintDescription='" + complaintDescription + '\'' +
                        ", complaintStatus='" + complaintStatus + '\'' +
                        ", complaintSLA='" + complaintSLA + '\'' +
                        ", importDateTime=" + importDateTime +
                        ", escalationDateTime=" + escalationDateTime +
                        ", serviceProvider='" + serviceProvider + '\'' +
                        ", actionTakenByAgent='" + actionTakenByAgent + '\'' +
                        ", reportingOfficer='" + reportingOfficer + '\'' +
                        ", subCategory='" + subCategory + '\'' +
                        ", sLABreachStatus=" + sLABreachStatus +
                        ", remarks='" + remarks + '\'' +
                        ", exported='" + exported + '\'' +
                        ", fileNameID='" + fileNameID + '\'' +
                        ", resolutionDateTime=" + resolutionDateTime +
                        ", resolutionNotes='" + resolutionNotes + '\'' +
                        ", transactionID=" + transactionID +
                        '}';
        }
}
