package com.techbank.account.cmd.api.commands

import com.techbank.cqrs.core.commands.BaseCommand
import lombok.Data

@Data
data class WithdrawFundsCommand(
    var amount: Double = 0.0
) : BaseCommand()