package com.spring.and.kotlin.springAndKotlin.domains

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.repositories.entities.Topico
import com.spring.and.kotlin.springAndKotlin.repositories.entities.enums.StatusTopico
import org.springframework.data.domain.Page
import java.time.LocalDateTime

class TopicoDomain(
        val id: Long? = 0,
        val titulo: String = "",
        val mensagem: String = "",
        val dataCriacao: LocalDateTime? = LocalDateTime.now(),
        val statusTopico: StatusTopico? = StatusTopico.NAO_RESPONDIDO,
        val autorDomain: UsuarioDomain? = null,
        val cursoDomain: CursoDomain? = null,
        val respostasDomain: List<RespostaDomain>? = emptyList()
)

fun TopicoDomain.toEntity(): Topico {
    return Topico(
            titulo = titulo,
            mensagem = mensagem,
            dataCriacao = dataCriacao,
            //autor = autorDomain!!.toEntity(),
            curso = cursoDomain!!.toEntity(),
            respostas = respostasDomain?.toEntity()
    )
}

fun TopicoDomain.toResponseDTO(): TopicoResponseDTO {
    return TopicoResponseDTO(
            id = id,
            titulo = titulo,
            mensagem = mensagem,
            dataCriacao = dataCriacao,
            statusTopico = statusTopico,
            autorResponse = autorDomain?.toResponseDTO(),
            cursoResponse = cursoDomain?.toResponseDTO()
            /*,
            respostas = respostasDomain?.toResponseDTO()*/
    )
}

fun TopicoDomain.updateTopico(topico: Topico): Topico {
    topico.titulo = titulo
    topico.mensagem = mensagem

    return topico
}

fun Page<TopicoDomain>.toResponseDTO(): Page<TopicoResponseDTO> {
    return map { it.toResponseDTO() }
}

fun List<TopicoDomain>.toResponseDTO(): List<TopicoResponseDTO> {
    return map { it.toResponseDTO() }
}