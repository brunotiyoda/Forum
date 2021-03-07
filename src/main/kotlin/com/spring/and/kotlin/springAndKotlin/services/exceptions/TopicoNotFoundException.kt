package com.spring.and.kotlin.springAndKotlin.services.exceptions

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(NOT_FOUND)
class TopicoNotFoundException(identifier: String? = null) : RuntimeException(identifier) {
}