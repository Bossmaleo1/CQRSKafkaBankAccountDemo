package com.techbank.account.cmd

import com.techbank.account.cmd.api.commands.*
import com.techbank.cqrs.core.infrastructure.CommandDispatcher
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CommandApplication(
	@Autowired
	private val commandDispatcher: CommandDispatcher,
	@Autowired
	private val commandHandler: CommandHandler,
)  {

	@PostConstruct
	fun registerHandlers() {
		commandDispatcher.registerHandler(OpenAccountCommand::class.java, commandHandler::handle)
		commandDispatcher.registerHandler(DepositFundsCommand::class.java, commandHandler::handle)
		commandDispatcher.registerHandler(WithdrawFundsCommand::class.java, commandHandler::handle)
		commandDispatcher.registerHandler(CloseAccountCommand::class.java, commandHandler::handle)
	}
}

fun main(args: Array<String>) {
	runApplication<CommandApplication>(*args)
}
