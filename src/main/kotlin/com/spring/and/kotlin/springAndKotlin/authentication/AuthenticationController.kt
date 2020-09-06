package com.spring.and.kotlin.springAndKotlin.authentication

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.LoginFormDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.TokenDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.toUsernamePasswordAuthenticationToken
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(
        private val authenticationManager: AuthenticationManager,
        private val tokenService: TokenService
) {

    @PostMapping
    fun auth(@RequestBody login: LoginFormDTO): ResponseEntity<TokenDTO> {
        val authentication = login.toUsernamePasswordAuthenticationToken(login)
        return try {
            val authenticate = authenticationManager.authenticate(authentication)

            val token = tokenService.getToken(authenticate)

            ResponseEntity.ok(TokenDTO("Bearen $token", "Bearen"))
        } catch (authExceptio: AuthenticationException) {
            ResponseEntity.badRequest().build()
        }
    }
}


