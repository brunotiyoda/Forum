package com.spring.and.kotlin.springAndKotlin.authentication

import com.spring.and.kotlin.springAndKotlin.repositories.entities.Usuario
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Service
class TokenService(
        @Value("\${forum.jwt.expiration}") private val expiration: String,
        @Value("\${forum.jwt.secret}") private val secret: String
) {

    fun getToken(authenticate: Authentication): String {
        val userIn = authenticate.principal as Usuario

        val today = LocalDateTime.now()
        val expirationDate = today.plusMinutes(expiration.toLong())

        return Jwts.builder()
                .setIssuer("API FORUM")
                .setSubject(userIn.id.toString())
                .setIssuedAt(Date.from(today.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expirationDate.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact()
    }

    fun isValid(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getIdUser(token: String?): Long {
        val body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).body
        return body.subject.toLong()
    }

}
