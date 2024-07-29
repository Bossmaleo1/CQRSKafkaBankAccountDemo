package com.techbank.cqrs.core.messages

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class  Message(val id: String = "")