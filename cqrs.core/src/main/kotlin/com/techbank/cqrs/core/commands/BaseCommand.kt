package com.techbank.cqrs.core.commands

import com.techbank.cqrs.core.messages.Message
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
abstract class BaseCommand(id: String = "") : Message(id)