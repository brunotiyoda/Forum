package com.spring.and.kotlin.springAndKotlin.controllers.dtos.response

import com.spring.and.kotlin.springAndKotlin.repositories.entities.Resposta
import com.spring.and.kotlin.springAndKotlin.repositories.entities.enums.StatusTopico
import java.time.LocalDateTime

data class TopicoResponseDTO(
        var id: Long? = 0,
        var titulo: String? = String(),
        var mensagem: String? = String(),
        var dataCriacao: LocalDateTime? = null,
        var statusTopico: StatusTopico? = null,
        var autorResponse: AutorResponseDTO? = null,
        var cursoResponse: CursoResponseDTO? = null,
        var respostas: List<Resposta>? = emptyList()
)

