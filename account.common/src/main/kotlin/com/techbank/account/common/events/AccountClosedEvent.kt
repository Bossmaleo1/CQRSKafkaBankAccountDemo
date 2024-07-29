package com.techbank.account.common.events

import com.techbank.account.common.events.FundsDepositedEvent.Builder
import com.techbank.cqrs.core.events.BaseEvent
import lombok.Data
import lombok.experimental.SuperBuilder

@Data
@SuperBuilder
class AccountClosedEvent : BaseEvent() {
    class Builder {
        private var id: String = ""

        fun id(id: String) = apply { this.id = id }

        fun build() = AccountClosedEvent()
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}