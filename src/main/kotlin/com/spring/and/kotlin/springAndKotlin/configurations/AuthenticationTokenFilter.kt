package com.spring.and.kotlin.springAndKotlin.configurations

import com.spring.and.kotlin.springAndKotlin.authentication.TokenService
import com.spring.and.kotlin.springAndKotlin.repositories.UsuarioRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationTokenFilter(
        private val tokenService: TokenService,
        private val usuarioRepository: UsuarioRepository
) : OncePerRequestFilter() {

    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        val token = toRecoverToken(request)
        val isValid = tokenService.isValid(token)

        if (isValid) {
            authenticateUser(token)
        }

        filterChain.doFilter(request, response)
    }

    private fun authenticateUser(token: String?) {
        val idUser = tokenService.getIdUser(token)
        val user = usuarioRepository.findById(idUser).get()
        val authentication = UsernamePasswordAuthenticationToken(user, null, user.getAuthorities())
        SecurityContextHolder.getContext().authentication = authentication
    }

    private fun toRecoverToken(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization")

        if (token == null || token.isEmpty()) {
            return null
        }

        return token.substring(7, token.length)
    }
}