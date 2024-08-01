package com.techbank.account.cmd.infrastructure

import com.techbank.cqrs.core.commands.BaseCommand
import com.techbank.cqrs.core.commands.CommandHandlerMethod
import com.techbank.cqrs.core.infrastructure.CommandDispatcher
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

@Service
class AccountCommandDispatcher(
    private val routes: MutableMap<Class<out BaseCommand>, MutableList<CommandHandlerMethod<out BaseCommand>>> = HashMap()
) : CommandDispatcher {


    override fun <T : BaseCommand> registerHandler(type: Class<T>, handler: CommandHandlerMethod<T>) {
        val handlers = routes.computeIfAbsent(type) { LinkedList() }
        handlers.add(handler as CommandHandlerMethod<out BaseCommand>)
    }

    override fun send(command: BaseCommand) {
        val handlers = routes[command::class.java]
        if (handlers.isNullOrEmpty()) {
            throw RuntimeException("No command handler was registered!")
        }
        if (handlers.size > 1) {
            throw RuntimeException("Cannot send command to more than one handler!")
        }
        println("On a notre ID : ${command.id} ")
        (handlers[0] as CommandHandlerMethod<BaseCommand>).handle(command)
    }
}