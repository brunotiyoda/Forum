package com.spring.and.kotlin.springAndKotlin.controllers.dtos.response

import com.spring.and.kotlin.springAndKotlin.domains.enums.StatusTopicoDomain
import com.spring.and.kotlin.springAndKotlin.entities.Resposta
import java.time.LocalDateTime

class TopicoResponseDTO() {

    var id: Long? = 0
    var titulo: String? = String()
    var mensagem: String? = String()
    var dataCriacao: LocalDateTime? = LocalDateTime.now()
    var statusTopido: StatusTopicoDomain? = StatusTopicoDomain.NAO_RESPONDIDO
    var autorResponse: AutorResponseDTO? = AutorResponseDTO()
    var cursoResponse: CursoResponseDTO? = CursoResponseDTO()
    var respostas: List<Resposta>? = listOf()

}
