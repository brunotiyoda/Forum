package com.spring.and.kotlin.springAndKotlin.controllers.dtos.request

import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain

data class TopicoRequestDTO(
        val titulo: String = "",
        val mensagem: String = "",
        val nomeCurso: String = ""
)

fun TopicoRequestDTO.toDomain(): TopicoDomain {
    return TopicoDomain(
            titulo = titulo,
            mensagem = mensagem,
            cursoDomain = CursoDomain(nome = nomeCurso)
    )
}