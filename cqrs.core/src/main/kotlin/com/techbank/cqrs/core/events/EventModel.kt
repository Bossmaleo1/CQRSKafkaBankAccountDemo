package com.techbank.cqrs.core.events

import lombok.Builder
import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.Date

@Data
@Builder
@Document(collection = "eventStore")
data class EventModel (
    @Id
    var  id: String? = "",
    var  timestamp: Date? = null,
    var aggregateIdentifier: String? = "",
    var aggregateType: String? = "",
    var version: Int? = 0,
    var eventType: String? = "",
    var eventData: BaseEvent? = null
) {

    class Builder {
        private var  id: String? = ""
        private var  timestamp: Date? = null
        private var aggregateIdentifier: String? = ""
        private var aggregateType: String? = ""
        private var version: Int? = 0
        private var eventType: String? = ""
        private var eventData: BaseEvent? = null

        fun id(id: String) = apply { this.id = id }
        fun timestamp(timestamp: Date) = apply { this.timestamp = timestamp }
        fun aggregateIdentifier(aggregateIdentifier: String) = apply { this.aggregateIdentifier = aggregateIdentifier }
        fun aggregateType(aggregateType: String) = apply { this.aggregateType = aggregateType }
        fun version(version: Int) = apply { this.version = version }
        fun eventType(eventType: String) = apply { this.eventType = eventType }
        fun eventData(eventData: BaseEvent) = apply { this.eventData = eventData }

        fun build() = EventModel(id, timestamp, aggregateIdentifier, aggregateType, version, eventType, eventData)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}