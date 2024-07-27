package com.techbank.account.cmd.api.commands

import com.techbank.cqrs.core.commands.BaseCommand

class CloseAccountCommand(private val id: String) : BaseCommand(id) {

}