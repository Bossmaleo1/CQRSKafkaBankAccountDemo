package com.techbank.account.query.infrastructure.handlers

import com.techbank.account.common.events.AccountClosedEvent
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.account.common.events.FundsDepositedEvent
import com.techbank.account.common.events.FundsWithdrawnEvent
import com.techbank.account.query.domain.AccountRepository
import com.techbank.account.query.domain.BankAccount
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountEventHandler(
    @Autowired private val repository: AccountRepository,
    private val accountRepository: AccountRepository
) : EventHandler {

    override fun on(event: AccountOpenedEvent) {
        val bankAccount = BankAccount.builder()
            .id(event.id)
            .accountHolder(event.accountHolder)
            .creationDate(event.createdDate!!)
            .accountType(event.accountType!!)
            .balance(event.openingBalance!!)
            .build()
        accountRepository.save(bankAccount)
    }

    override fun on(event: FundsDepositedEvent) {
        val bankAccount = accountRepository.findById(event.id)
        if (bankAccount.isEmpty) { return }
        val currentBalance = bankAccount.get().balance
        val latestBalance = currentBalance + event.amount
        bankAccount.get().balance = latestBalance
        accountRepository.save(bankAccount.get())
    }

    override fun on(event: FundsWithdrawnEvent) {
        val bankAccount = accountRepository.findById(event.id)
        if (bankAccount.isEmpty) { return }
        val currentBalance = bankAccount.get().balance
        val latestBalance = currentBalance - event.amount
        bankAccount.get().balance = latestBalance
        accountRepository.save(bankAccount.get())
    }

    override fun on(event: AccountClosedEvent) {
        accountRepository.deleteById(event.id)
    }
}