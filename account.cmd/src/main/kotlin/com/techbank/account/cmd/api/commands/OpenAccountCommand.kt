package com.techbank.account.cmd.api.commands

import com.techbank.account.common.dto.AccountType
import com.techbank.cqrs.core.commands.BaseCommand

class OpenAccountCommand : BaseCommand() {
    private val accountHolder: String = ""
    private val accountType: AccountType? = null
    private val openingBalance: Double = 0.0
}