package com.techbank.cqrs.core.commands

fun interface CommandHandlerMethod<T : BaseCommand?> {
    fun handle(command: T)
}


