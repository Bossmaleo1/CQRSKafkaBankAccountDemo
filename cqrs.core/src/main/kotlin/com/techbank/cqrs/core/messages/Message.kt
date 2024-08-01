package com.techbank.cqrs.core.messages

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class  Message(@Id open var id: String = "")