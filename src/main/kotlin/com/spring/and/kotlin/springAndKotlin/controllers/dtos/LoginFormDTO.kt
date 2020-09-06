package com.spring.and.kotlin.springAndKotlin.controllers.dtos

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

data class LoginFormDTO(
        val email: String,
        val senha: String
) {

}

fun LoginFormDTO.toUsernamePasswordAuthenticationToken(login: LoginFormDTO): UsernamePasswordAuthenticationToken {
    return UsernamePasswordAuthenticationToken(login.email, login.senha)
}