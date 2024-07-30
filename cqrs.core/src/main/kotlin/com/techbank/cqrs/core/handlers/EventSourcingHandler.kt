package com.techbank.cqrs.core.handlers

import com.techbank.cqrs.core.domain.AggregateRoot

interface EventSourcingHandler<T> {
    fun save(aggregate: AggregateRoot)
    fun getById(id: String): T?
}