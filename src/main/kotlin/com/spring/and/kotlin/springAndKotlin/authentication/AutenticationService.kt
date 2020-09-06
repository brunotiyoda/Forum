package com.spring.and.kotlin.springAndKotlin.authentication

import com.spring.and.kotlin.springAndKotlin.repositories.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AutenticationService(
        private val usuarioRepository: UsuarioRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val usuario = usuarioRepository.findByEmail(email)

        return usuario.map { usuario.get() }.orElseThrow { throw UsernameNotFoundException("e-mail ou senha incorretos") }
    }
}