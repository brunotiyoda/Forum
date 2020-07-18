package com.spring.and.kotlin.springAndKotlin.domains

import com.spring.and.kotlin.springAndKotlin.domains.enums.StatusTopicoDomain
import java.time.LocalDateTime

class TopicoDomain(
        val id: Long,
        val titulo: String,
        val mensagem: String,
        val dataCriacao: LocalDateTime,
        val statusTopidoDomain: StatusTopicoDomain,
        val autor: UsuarioDomain,
        val cursoDomain: CursoDomain,
        val respostasDomain: MutableList<RespostaDomain>
) {

    class Builder(
            var id: Long = 0,
            var titulo: String = "",
            var mensagem: String = "",
            var dataCriacao: LocalDateTime = LocalDateTime.now(),
            var statusTopidoDomain: StatusTopicoDomain = StatusTopicoDomain.NAO_RESPONDIDO,
            var autor: UsuarioDomain = UsuarioDomain.Builder().build(),
            var cursoDomain: CursoDomain = CursoDomain.Builder().build(),
            var respostasDomain: MutableList<RespostaDomain> = mutableListOf()
    ) {
        fun withId(id: Long) = apply { this.id = id }
        fun withTitulo(titulo: String) = apply { this.titulo = titulo }
        fun withMensagem(mensagem: String) = apply { this.mensagem = mensagem }
        fun withDataCriacao(dataCriacao: LocalDateTime) = apply { this.dataCriacao = dataCriacao }
        fun withStatusTopicoDomain(statusTopidoDomain: StatusTopicoDomain) = apply { this.statusTopidoDomain = statusTopidoDomain }
        fun withAutor(autor: UsuarioDomain) = apply { this.autor = autor }
        fun withCursoDomain(cursoDomain: CursoDomain) = apply { this.cursoDomain = cursoDomain }
        fun withRespostasDomain(respostasDomain: MutableList<RespostaDomain>) = apply { this.respostasDomain = respostasDomain }
        fun build() = TopicoDomain(id, titulo, mensagem, dataCriacao, statusTopidoDomain, autor, cursoDomain, respostasDomain)
    }

}