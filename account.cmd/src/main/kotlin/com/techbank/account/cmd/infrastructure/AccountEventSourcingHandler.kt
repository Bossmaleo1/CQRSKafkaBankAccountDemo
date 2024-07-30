package com.techbank.account.cmd.infrastructure

import com.techbank.account.cmd.domain.AccountAggregate
import com.techbank.cqrs.core.domain.AggregateRoot
import com.techbank.cqrs.core.events.BaseEvent
import com.techbank.cqrs.core.handlers.EventSourcingHandler
import com.techbank.cqrs.core.infrastructure.EventStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountEventSourcingHandler(
    @Autowired private val eventStore: EventStore
) : EventSourcingHandler<AccountAggregate> {

    override fun save(aggregate: AggregateRoot) {
        eventStore.saveEvents(aggregate.id!!, aggregate.uncommittedChanges, aggregate.version)
        aggregate.markChangesAsCommitted()
    }

    override fun getById(id: String): AccountAggregate? {
        val aggregate = AccountAggregate()
        val events: List<BaseEvent> = eventStore.getEvents(id)
        if (events.isNotEmpty()) {
            aggregate.replayEvents(events)
            val latestVersion = events.stream().map { x -> x.version }.max(Comparator.naturalOrder())
            aggregate.version = latestVersion.get()
        }
        return aggregate
    }
}