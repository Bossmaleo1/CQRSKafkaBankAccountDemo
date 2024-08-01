package com.techbank.account.cmd.api.controllers

import com.techbank.account.cmd.api.commands.DepositFundsCommand
import com.techbank.account.common.dto.BaseResponse
import com.techbank.cqrs.core.infrastructure.CommandDispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.MessageFormat
import java.util.logging.Level
import java.util.logging.Logger

@RestController
@RequestMapping("api/v1/depositFunds")
class DepositFundsController(
    @Autowired private val commandDispatcher: CommandDispatcher
) {

    private val logger: Logger? = Logger.getLogger(OpenAccountController::class.java.name)

    @PutMapping("/{id}")
    fun depositFunds(@PathVariable(value = "id") id: String,
                     @RequestBody command: DepositFundsCommand): ResponseEntity<BaseResponse> {
        try {
            command.id = id
            commandDispatcher.send(command)
            return ResponseEntity(BaseResponse("Deposit funds request completed successfully!"), HttpStatus.OK)
        } catch(e: IllegalStateException) {
            logger!!.log(Level.WARNING, "Client made a bad request - %s", e.toString())
            return ResponseEntity(BaseResponse(""), HttpStatus.BAD_REQUEST)
        } catch(e: Exception) {
            val safeErrorMessage = MessageFormat.format("Error while processing request to deposit funds to bank account with id: %s.", id)
            logger!!.log(Level.SEVERE, safeErrorMessage, e)
            return ResponseEntity(BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }
}