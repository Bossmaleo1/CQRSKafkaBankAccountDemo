package com.techbank.cqrs.core.producers

import com.techbank.cqrs.core.events.BaseEvent
import org.springframework.stereotype.Component

@Component
interface EventProducer {
    fun produce(topic: String, event: BaseEvent)
}