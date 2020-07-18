package com.spring.and.kotlin.springAndKotlin.domains

import java.time.LocalDateTime

class RespostaDomain(
        val id: Long,
        val mensagem: String,
        val topico: TopicoDomain,
        val dataCriacao: LocalDateTime,
        val autor: UsuarioDomain?,
        val solucacao: Boolean
) {

    class Builder(
            var id: Long,
            var mensagem: String,
            var topico: TopicoDomain,
            var dataCriacao: LocalDateTime,
            var autor: UsuarioDomain,
            var solucacao: Boolean
    ) {
        fun withId(id: Long) = apply { this.id = id }
        fun withMensagem(mensagem: String) = apply { this.mensagem = mensagem }
        fun withTopico(topico: TopicoDomain) = apply { this.topico = topico }
        fun withDataCriacao(dataCriacao: LocalDateTime) = apply { this.dataCriacao = dataCriacao }
        fun withAutor(autor: UsuarioDomain) = apply { this.autor = autor }
        fun withSolucao(solucacao: Boolean) = apply { this.solucacao = solucacao }
        fun build() = RespostaDomain(id, mensagem, topico, dataCriacao, autor, solucacao)
    }

}
