package com.techbank.account.cmd.api.commands

import com.techbank.account.common.dto.AccountType
import com.techbank.cqrs.core.commands.BaseCommand

class OpenAccountCommand : BaseCommand() {
    val accountHolder: String = ""
    val accountType: AccountType? = null
    val openingBalance: Double = 0.0
}