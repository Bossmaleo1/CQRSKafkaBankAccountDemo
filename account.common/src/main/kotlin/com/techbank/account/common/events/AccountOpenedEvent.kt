package com.techbank.account.common.events

import com.techbank.account.common.dto.AccountType
import com.techbank.cqrs.core.events.BaseEvent
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import lombok.experimental.SuperBuilder
import java.util.*

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
class AccountOpenedEvent(
      val accountHolder: String = "",
      val accountType: AccountType? = null,
      val createdDate: Date? = null,
      val openingBalance: Double? = null
) : BaseEvent() {

      class Builder {
            private var id: String = ""
            private var accountHolder: String = ""
            private var accountType: AccountType? = null
            private var createdDate: Date? = null
            private var openingBalance: Double? = null

            fun id(id: String) = apply { this.id = id }
            fun accountHolder(accountHolder: String) = apply { this.accountHolder = accountHolder }
            fun accountType(accountType: AccountType) = apply { this.accountType = accountType }
            fun createdDate(createdDate: Date?) = apply { this.createdDate = createdDate }
            fun openingBalance(openingBalance: Double?) = apply { this.openingBalance = openingBalance }

            fun build() = AccountOpenedEvent(accountHolder, accountType, createdDate, openingBalance)
      }

      companion object {
            @JvmStatic
            fun builder() = Builder()
      }
}