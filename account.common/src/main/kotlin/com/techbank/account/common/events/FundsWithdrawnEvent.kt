package com.techbank.account.common.events

import com.techbank.account.common.events.FundsDepositedEvent.Builder
import com.techbank.cqrs.core.events.BaseEvent

class FundsWithdrawnEvent(override var id: String = "",val amount: Double = 0.0) : BaseEvent(id) {

    class Builder {
        private var id: String = ""
        private var amount: Double = 0.0

        fun id(id: String) = apply { this.id = id }
        fun amount(amount: Double) = apply { this.amount = amount }

        fun build() = FundsDepositedEvent(id, amount)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }

}