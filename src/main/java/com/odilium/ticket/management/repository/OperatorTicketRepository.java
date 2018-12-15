package com.odilium.ticket.management.repository;

import com.odilium.ticket.management.entities.OperatorTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorTicketRepository extends JpaRepository<OperatorTicket, Long> {
}
