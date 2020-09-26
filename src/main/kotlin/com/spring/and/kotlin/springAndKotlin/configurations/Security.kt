package com.spring.and.kotlin.springAndKotlin.configurations

import com.spring.and.kotlin.springAndKotlin.authentication.AutenticationService
import com.spring.and.kotlin.springAndKotlin.authentication.TokenService
import com.spring.and.kotlin.springAndKotlin.repositories.UsuarioRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class Security(
        private val autenticationService: AutenticationService,
        private val tokenService: TokenService,
        private val usuarioRepository: UsuarioRepository
) : WebSecurityConfigurerAdapter() {

    // configure auths
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(autenticationService).passwordEncoder(BCryptPasswordEncoder())
    }

    // configure static resources (js, css, img)
    override fun configure(web: WebSecurity?) {
    }

    // configure authorization
    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .antMatchers(HttpMethod.GET, "/topicos").permitAll()
                .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.DELETE, "/topicos/*").hasRole("MODERADOR")
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(
                        AuthenticationTokenFilter(tokenService, usuarioRepository),
                        UsernamePasswordAuthenticationFilter::class.java
                )
    }

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }
}