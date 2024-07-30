package com.techbank.cqrs.core.producers

import com.techbank.cqrs.core.events.BaseEvent

interface EventProducer {
    fun produce(topic: String, event: BaseEvent)
}