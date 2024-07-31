package com.techbank.account.common.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@NoArgsConstructor
@AllArgsConstructor
data class BaseResponse(
    var message: String? = null,
)