package com.techbank.cqrs.core.infrastructure

import com.techbank.cqrs.core.commands.BaseCommand
import com.techbank.cqrs.core.commands.CommandHandlerMethod

interface CommandDispatcher {
    fun <T : BaseCommand>  registerHandler(type: Class<T>, handler: CommandHandlerMethod<T>)
    fun send(command: BaseCommand)
}