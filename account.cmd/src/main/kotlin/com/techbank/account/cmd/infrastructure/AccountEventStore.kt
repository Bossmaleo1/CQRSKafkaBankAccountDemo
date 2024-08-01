package com.techbank.account.cmd.infrastructure

/*import com.techbank.cqrs.core.Exceptions.AggregateNotFoundException
import com.techbank.cqrs.core.Exceptions.ConcurrencyException
import com.techbank.account.cmd.domain.AccountAggregate
import com.techbank.account.cmd.domain.EventStoreRepository
import com.techbank.cqrs.core.events.BaseEvent
import com.techbank.cqrs.core.events.EventModel
import com.techbank.cqrs.core.infrastructure.EventStore
import com.techbank.cqrs.core.producers.EventProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class AccountEventStore(
    @Autowired
    private val eventProducer: EventProducer,
    @Autowired
    private val eventStoreRepository: EventStoreRepository
): EventStore {


    override fun saveEvents(aggregateId: String, events: Iterable<BaseEvent>, expectedVersion: Int) {
        val eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId)
        if (expectedVersion != -1 && eventStream[eventStream.size - 1].version == expectedVersion) {
            throw ConcurrencyException()
        }
        var version = expectedVersion
        for (event in events) {
            version++
            event.version = version
            val eventModel = EventModel.builder()
            .version(version)
                .timestamp(timestamp = Date())
                .aggregateIdentifier(aggregateId)
                .aggregateType(AccountAggregate::class.java.typeName)
                .version(version)
                .eventType(eventType = event.javaClass.typeName)
                .eventData(event)
                .build()
            val persistedEvent = eventStoreRepository.save(eventModel)
            if (persistedEvent.id!!.isNotEmpty()) {
                // ToDo: produce event to kafka
                eventProducer.produce(event.javaClass.simpleName, event)
            }
        }
    }

    override fun getEvents(aggregateId: String): MutableList<BaseEvent> {
        val eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId)
        if (eventStream.isEmpty()) {
            throw AggregateNotFoundException("Incorrect account ID provided!")
        }
        return eventStream.stream().map { x -> x.eventData }.collect(Collectors.toList())
    }


}*/

import com.techbank.account.cmd.api.controllers.OpenAccountController
import com.techbank.account.cmd.domain.AccountAggregate
import com.techbank.account.cmd.domain.EventStoreRepository
import com.techbank.cqrs.core.Exceptions.AggregateNotFoundException
import com.techbank.cqrs.core.Exceptions.ConcurrencyException
import com.techbank.cqrs.core.events.BaseEvent
import com.techbank.cqrs.core.events.EventModel.Companion.builder
import com.techbank.cqrs.core.infrastructure.EventStore
import com.techbank.cqrs.core.producers.EventProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.text.MessageFormat
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import java.util.stream.Collectors

@Service
class AccountEventStore : EventStore {
    @Autowired
    private val eventProducer: EventProducer? = null

    @Autowired
    private val eventStoreRepository: EventStoreRepository? = null

    private val logger: Logger? = Logger.getLogger(AccountEventStore::class.java.name)



    override fun saveEvents(aggregateId: String, events: Iterable<BaseEvent>, expectedVersion: Int) {
        val eventStream = eventStoreRepository!!.findByAggregateIdentifier(aggregateId)
        if (expectedVersion != -1 && eventStream[eventStream.size - 1].version != expectedVersion) {
            throw ConcurrencyException()
        }
        var version = expectedVersion
        for (event in events) {
            version++
            event.version = version
            val eventModel = builder()
                .id(event.id)
                .timestamp(timestamp = Date())
                .aggregateIdentifier(aggregateId)
                .aggregateType(AccountAggregate::class.java.typeName)
                .version(version)
                .eventType(eventType = event.javaClass.typeName)
                .eventData(event)
                .build()
            val persistedEvent = eventStoreRepository.save(eventModel)
            persistedEvent.id = event.id
            logger!!.log(Level.WARNING, MessageFormat.format("ID EVent - %s", event.id))
            println("ID Event MALEO-SAMA ${eventModel.id}")
            println("ID Event MALEO-SAMA ${eventModel.id}")
            if (persistedEvent.id!!.isNotEmpty()) {
                // ToDo: produce event to kafka
                eventProducer!!.produce(event.javaClass.simpleName, event)
            }

            /*if (persistedEvent.id!!.isNotEmpty()) {
                eventProducer!!.produce(event.javaClass.simpleName, event)
            }*/
        }
    }

    override fun getEvents(aggregateId: String): MutableList<BaseEvent> {
        val eventStream = eventStoreRepository!!.findByAggregateIdentifier(aggregateId)
        if (eventStream.isEmpty()) {
            throw AggregateNotFoundException("Incorrect account ID provided!")
        }
        return eventStream.stream().map { x -> x.eventData }.collect(Collectors.toList())
    }
}
