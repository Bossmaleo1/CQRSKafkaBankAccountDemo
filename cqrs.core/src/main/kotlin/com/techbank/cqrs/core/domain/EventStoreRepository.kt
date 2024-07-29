package com.techbank.cqrs.core.domain

import com.techbank.cqrs.core.events.EventModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EventStoreRepository : MongoRepository<EventModel, String> {
    fun findByAggregateIdentifier(aggregateIdentifier: String): List<EventModel>
}