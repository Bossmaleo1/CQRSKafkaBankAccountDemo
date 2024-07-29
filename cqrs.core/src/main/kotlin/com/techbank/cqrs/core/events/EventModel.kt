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
)