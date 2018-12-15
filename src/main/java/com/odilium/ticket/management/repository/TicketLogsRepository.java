package com.odilium.ticket.management.repository;

import com.odilium.ticket.management.mongo.entities.TicketLogs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface TicketLogsRepository extends MongoRepository<TicketLogs, String> {

    List<TicketLogs> findByTicketIDOrConsumerPhoneNumber(String ticketID, String phoneNumber);

    List<TicketLogs> findByticketID(String ticketID);

    Stream<TicketLogs> findByTicketIssuedDateTimeBetween(Date transactionStartTime, Date transactionEndTime);
}
