package com.techbank.cqrs.core.messages

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class  Message(private val id: String = "")