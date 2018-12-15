package com.odilium.ticket.management.repository;

import com.odilium.ticket.management.entities.TicketFollowUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketFollowUpRepository extends JpaRepository<TicketFollowUp, Long> {
}
