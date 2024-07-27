package com.techbank.account.cmd.api.commands

import com.techbank.cqrs.core.commands.BaseCommand
import lombok.Data

@Data
class DepositFundsCommand : BaseCommand() {
    private val amount: Double = 0.0
}