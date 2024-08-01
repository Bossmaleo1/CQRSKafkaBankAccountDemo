package com.techbank.account.cmd.infrastructure

import com.techbank.cqrs.core.events.BaseEvent
import com.techbank.cqrs.core.producers.EventProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class AccountEventProducer(
    @Autowired val kafkaTemplate: KafkaTemplate<String, Any>
) : EventProducer {

    override fun produce(topic: String, event: BaseEvent) {
       this.kafkaTemplate.send(topic, event)
    }
}