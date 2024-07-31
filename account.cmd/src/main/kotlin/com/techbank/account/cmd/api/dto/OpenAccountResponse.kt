package com.techbank.account.cmd.api.dto

import com.techbank.account.common.dto.BaseResponse

class OpenAccountResponse (
    var id: String,
    override var message: String?
): BaseResponse(message)