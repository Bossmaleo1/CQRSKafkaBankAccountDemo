package com.techbank.account.query.domain

import com.techbank.account.common.dto.AccountType
import com.techbank.account.common.events.AccountOpenedEvent
import com.techbank.cqrs.core.domain.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.Date


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
data class BankAccount(
    @Id
    var id: String? = "",
    var accountHolder: String = "",
    var creationDate: Date? = null,
    var accountType: AccountType? = null,
    var balance: Double = 0.0,
): BaseEntity() {

    class Builder {
        private var id: String? = ""
        private var accountHolder: String = ""
        private var creationDate: Date? = null
        private var accountType: AccountType? = null
        private var balance: Double = 0.0

        fun id(id: String) = apply { this.id = id }
        fun accountHolder(accountHolder: String) = apply { this.accountHolder = accountHolder }
        fun creationDate(creationDate: Date) = apply { this.creationDate = creationDate }
        fun accountType(accountType: AccountType) = apply { this.accountType = accountType }
        fun balance(balance: Double) = apply { this.balance = balance }

        fun build() = BankAccount(id, accountHolder, creationDate, accountType, balance)
    }

    companion object {
        @JvmStatic
        fun builder() = Builder()
    }
}