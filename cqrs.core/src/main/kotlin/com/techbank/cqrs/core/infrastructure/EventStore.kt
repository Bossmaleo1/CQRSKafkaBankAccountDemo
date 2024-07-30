package com.techbank.cqrs.core.infrastructure

import com.techbank.cqrs.core.events.BaseEvent

interface EventStore {
    fun saveEvents(aggregateId: String, events: Iterable<BaseEvent>, expectedVersion: Int)
    fun getEvents(aggregateId: String): List<BaseEvent>
}