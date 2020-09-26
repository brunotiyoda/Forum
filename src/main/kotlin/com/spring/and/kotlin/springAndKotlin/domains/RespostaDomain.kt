package com.spring.and.kotlin.springAndKotlin.domains

import com.spring.and.kotlin.springAndKotlin.repositories.entities.Resposta
import java.time.LocalDateTime

data class RespostaDomain(
        val id: Long? = 0,
        val mensagem: String = "",
        val topico: TopicoDomain? = null,
        val dataCriacao: LocalDateTime? = null,
        val autor: UsuarioDomain? = null,
        val solucacao: Boolean? = false
)

fun RespostaDomain.toEntity(): Resposta {
    return Resposta(
            mensagem = mensagem
    )
}

fun List<RespostaDomain>.toEntity(): List<Resposta>? {
    return map { it.toEntity() }
}