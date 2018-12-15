package com.odilium.ticket.management.repository;

import com.odilium.ticket.management.entities.AgentTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentTicketRepository extends JpaRepository<AgentTicket, Long> {

    List<AgentTicket> findByComplaintTicketID(String complaintTicketID);
}
