package com.techbank.account.common.events

import com.techbank.cqrs.core.events.BaseEvent
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.SuperBuilder
import java.util.*

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class AccountOpenedEvent : BaseEvent() {
    private val accountHolder: String  = ""
    private val accountType: String  = ""
    private val createdDate: Date? = null
    private val openingBalance: Double? = null
}