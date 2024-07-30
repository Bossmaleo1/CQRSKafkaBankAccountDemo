package com.techbank.account.common.events

import com.techbank.account.common.events.FundsDepositedEvent.Builder
import com.techbank.cqrs.core.events.BaseEvent

class FundsWithdrawnEvent(val amount: Double = 0.0) : BaseEvent() {

    class Builder {
        private var id: String = ""
        private var amount: Double = 0.0

        fun id(id: String) = apply { this.id = id }
        fun amount(amount: Double) = apply { this.amount = amount }

        fun build() = FundsDepositedEvent(amount)
    }

    companion object {
        @JvmStatic
        fun builder() = FundsDepositedEvent.Builder()
    }

}