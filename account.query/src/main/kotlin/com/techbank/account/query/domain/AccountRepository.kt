package com.techbank.account.query.domain

import com.techbank.cqrs.core.domain.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface AccountRepository : JpaRepository<BankAccount, String> {
    fun findByAccountHolder(accountId: String): Optional<BankAccount>
    fun findByBalanceGreaterThan(balance: Double): List<BaseEntity>
    fun findByBalanceLessThan(balance: Double): List<BaseEntity>
}