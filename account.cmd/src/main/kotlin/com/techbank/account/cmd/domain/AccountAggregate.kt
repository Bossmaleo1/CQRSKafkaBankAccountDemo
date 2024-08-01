package com.techbank.account.cmd.domain

import com.techbank.account.cmd.api.commands.OpenAccountCommand
import com.techbank.account.common.events.AccountClosedEvent
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.account.common.events.FundsDepositedEvent
import com.techbank.account.common.events.FundsWithdrawnEvent
import com.techbank.cqrs.core.domain.AggregateRoot
import lombok.NoArgsConstructor
import java.util.*

/*@NoArgsConstructor
class AccountAggregate(command: OpenAccountCommand) : AggregateRoot() {
    private var active: Boolean? = null
    private var balance = 0.0

    init {
        raiseEvent(
            AccountOpenedEvent.builder()
                .id(command.id)
                .accountHolder(command.accountHolder)
                .createdDate(Date())
                .accountType(command.accountType!!)
                .openingBalance(command.openingBalance)
                .build()
        )
    }

    fun getBalance(): Double {
        return balance
    }

    fun apply(event: AccountOpenedEvent) {
        this.id = event.id
        this.active = true
        this.balance = event.openingBalance!!
    }

    fun depositFunds(amount: Double) {
        if(!this.active!!) {
            throw IllegalArgumentException("Funds cannot be deposited into a closed account!")
        }

        if(amount <= 0.0) {
            throw IllegalStateException("The deposit amount must be greater than 0!")
        }

        raiseEvent(
            FundsDepositedEvent.builder()
                .id(this.id!!)
                .amount(amount)
                .build()
        )
    }

    fun apply(event: FundsDepositedEvent) {
        this.id = event.id
        this.balance += event.amount
    }

    fun withdrawFunds(amount: Double) {
        if(!this.active!!) {
            throw IllegalStateException("Funds cannot be withdrawn from a closed account!")
        }

        raiseEvent(
            FundsWithdrawnEvent.builder()
                .id(this.id!!)
                .amount(amount)
                .build())
    }

    fun apply(event: FundsWithdrawnEvent) {
        this.id = event.id
        this.balance -= event.amount
    }

    fun closeAccount() {
        if(!this.active!!) {
            throw IllegalStateException("The bank account has already been closed!")
        }
        raiseEvent(
            AccountClosedEvent.builder()
                .id(this.id!!)
                .build()
        )
    }

    fun apply(event: AccountClosedEvent) {
        this.id = event.id
        this.active = false
    }



}
*/

@NoArgsConstructor
class AccountAggregate(command: OpenAccountCommand) : AggregateRoot() {
    private var active: Boolean? = null
    var balance: Double = 0.0

    init {
        raiseEvent(
            AccountOpenedEvent.builder()
                .id(command.id)
                .accountHolder(command.accountHolder)
                .createdDate(Date())
                .accountType(command.accountType!!)
                .openingBalance(command.openingBalance)
                .build()
        )
    }

    fun apply(event: AccountOpenedEvent) {
        this.id = event.id
        this.active = true
        this.balance = event.openingBalance!!
    }

    fun depositFunds(amount: Double) {
        check(active!!) { "Funds cannot be deposited into a closed account!" }
        check(!(amount <= 0)) { "The deposit amount must be greater than 0!" }
        raiseEvent(
            FundsDepositedEvent.builder()
                .id(id!!)
                .amount(amount)
                .build()
        )
    }

    fun apply(event: FundsDepositedEvent) {
        this.id = event.id
        this.balance += event.amount
    }

    fun withdrawFunds(amount: Double) {
        check(active!!) { "Funds cannot be withdrawn from a closed account!" }
        raiseEvent(
            FundsWithdrawnEvent.builder()
                .id(id!!)
                .amount(amount)
                .build()
        )
    }

    fun apply(event: FundsWithdrawnEvent) {
        this.id = event.id
        this.balance -= event.amount
    }

    fun closeAccount() {
        check(active!!) { "The bank account has already been closed!" }
        raiseEvent(
            AccountClosedEvent.builder()
                .id(id!!)
                .build()
        )
    }

    fun apply(event: AccountClosedEvent) {
        this.id = event.id
        this.active = false
    }
}
