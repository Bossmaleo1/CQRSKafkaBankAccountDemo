package com.techbank.account.common.events

import com.techbank.cqrs.core.events.BaseEvent
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.SuperBuilder

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class FundsDepositedEvent(val amount: Double = 0.0) : BaseEvent() {
    class Builder {
        private var id: String = ""
        private var amount: Double = 0.0

        fun id(id: String) = apply { this.id = id }
        fun amount(amount: Double) = apply { this.amount = amount }

        fun build() = FundsDepositedEvent(amount)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}