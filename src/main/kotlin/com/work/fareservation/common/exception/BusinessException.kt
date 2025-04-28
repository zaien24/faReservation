package com.work.fareservation.common.exception

class BusinessException(
    override val message: String
) : RuntimeException(message)