package com.techbank.account.common.events

import com.techbank.cqrs.core.events.BaseEvent

class FundsWithdrawnEvent  : BaseEvent() {
    private val amount: Double = 0.0
}