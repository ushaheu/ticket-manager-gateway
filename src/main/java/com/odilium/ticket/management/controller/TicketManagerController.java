package com.odilium.ticket.management.controller;

import com.odilium.ticket.management.entities.AgentTicket;
import com.odilium.ticket.management.entities.OperatorTicket;
import com.odilium.ticket.management.mongo.entities.TicketLogs;
import com.odilium.ticket.management.service.AgentTicketService;
import com.odilium.ticket.management.service.OperatorTicketService;
import com.odilium.ticket.management.service.ReportsService;
import com.odilium.ticket.management.service.TicketLogsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TicketManagerController {

    private AgentTicketService agentTicketService;
    private TicketLogsService ticketLogsService;
    private OperatorTicketService operatorTicketService;
    private ReportsService reportsService;

    @Autowired
    public TicketManagerController(AgentTicketService agentTicketService, TicketLogsService ticketLogsService, OperatorTicketService operatorTicketService, ReportsService reportsService) {
        this.agentTicketService = agentTicketService;
        this.ticketLogsService = ticketLogsService;
        this.operatorTicketService = operatorTicketService;
        this.reportsService = reportsService;
    }

    @CrossOrigin
    @GetMapping(value = "/v1/agents/searchTicket/ticketId/phoneNumber")
    @ApiOperation(value = "findTicketLogsByTicketIDOrPhoneNumber", notes = "Search Ticket Using Phone Number or Ticket ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public List<TicketLogs> findTicketLogsByTicketIDOrPhoneNumber(String ticketID, String phoneNumber){
        return ticketLogsService.findTicketLogsByTicketIDOrPhoneNumber(ticketID, phoneNumber);
    }

    @CrossOrigin
    @PostMapping(value = "/v1/agents/createAgentTicket")
    @ApiOperation(value = "createAgentTicket", notes = "Create Agent Ticket")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void createAgentTicket(@RequestBody AgentTicket agentTicket){
        agentTicketService.createAgentTicket(agentTicket);
    }

    @PostMapping(value = "/v1/operators/createOperatorTicket")
    @ApiOperation(value = "createOperatorTicket", notes = "Create Operator Ticket")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void createOperatorTicket(@RequestBody OperatorTicket operatorTicket){
        operatorTicketService.createOperatorTicket(operatorTicket);
    }

    @CrossOrigin
    @PostMapping(value = "/v1/agents/updateAgentTicket")
    @ApiOperation(value = "updateAgentTicket", notes = "Update Agent Ticket")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAgentTicket(String ticketID, String status){
        agentTicketService.updateTicketStatus(ticketID, status);
        ticketLogsService.updateTicketStatus(ticketID, status);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/getTicketCountByStatus")
    @ApiOperation(value = "ticketCountByStatus", notes = "Ticket Count By Status")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Long> groupAllTicketsByStatus(@RequestParam(name = "startDateString") String startDateString, @RequestParam(name = "endDateString") String endDateString){
        return reportsService.groupCountAllTicketLogsByComplaintStatus(startDateString, endDateString);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/getTicketCountByStateOfOrigin")
    @ApiOperation(value = "ticketCountByStateOfOrigin", notes = "Ticket Count By State Of Origin")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Long> groupAllTicketsByStateOfOrigin(@RequestParam(name = "startDateString") String startDateString, @RequestParam(name = "endDateString") String endDateString){
        return reportsService.groupCountAllTicketLogsByStateOfOrigin(startDateString, endDateString);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/getTicketCountByZone")
    @ApiOperation(value = "ticketCountByZone", notes = "Ticket Count By Zone")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Long> groupAllTicketsByZone(@RequestParam(name = "startDateString") String startDateString, @RequestParam(name = "endDateString") String endDateString){
        return reportsService.groupCountAllTicketLogsByZone(startDateString, endDateString);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/getTicketCountByComplaintCode")
    @ApiOperation(value = "ticketCountByComplaintCode", notes = "Ticket Count By Complaint Code")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Long> groupAllTicketsByComplaintCode(@RequestParam(name = "startDateString") String startDateString, @RequestParam(name = "endDateString") String endDateString){
        return reportsService.groupCountAllTicketLogsByComplaintCode(startDateString, endDateString);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/groupCountAllTicketLogsByOperatorByStatus")
    @ApiOperation(value = "groupCountAllTicketLogsByOperatorByStatus", notes = "Ticket Count Per Operator Filtered By Status")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Map<String, Long>> groupCountAllTicketLogsByOperatorByStatus(@RequestParam(name = "startDateString") String startDateString, @RequestParam(name = "endDateString") String endDateString){
        return reportsService.groupCountAllTicketLogsByOperatorByStatus(startDateString, endDateString);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/groupCountAllTicketLogsByStatePerServiceProvider")
    @ApiOperation(value = "groupCountAllTicketLogsByStatePerServiceProvider", notes = "Ticket Count By State Filtered By Status")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Map<String, Long>> groupCountAllTicketLogsByStatePerServiceProvider(@RequestParam(name = "startDateString") String startDateString, @RequestParam(name = "endDateString") String endDateString){
        return reportsService.groupCountAllTicketLogsByStatePerServiceProvider(startDateString, endDateString);
    }

    @CrossOrigin
    @GetMapping(value = "/v1/analytics/groupCountAllTicketLogsByStatus")
    @ApiOperation(value = "groupCountAllTicketLogsByStatus", notes = "Ticket Count By Complaint Status")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
    })
    public Map<String, Long> groupCountAllTicketLogsByStatus(){
        return reportsService.groupCountAllTicketLogsByStatus();
    }
}
