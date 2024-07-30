package com.techbank.account.query.domain

import com.techbank.cqrs.core.domain.BaseEntity
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface AccountRepository : CrudRepository<BankAccount, String> {
    fun findByAccountHolder(accountId: String): Optional<BankAccount>
    fun findByBalanceGreaterThan(balance: Double): List<BaseEntity>
    fun findByBalanceLessThan(balance: Double): List<BaseEntity>
}