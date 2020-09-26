package com.spring.and.kotlin.springAndKotlin.repositories.entities

import com.spring.and.kotlin.springAndKotlin.domains.RespostaDomain
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @Column(name = "mensagem")
        val mensagem: String = String(),

        @ManyToOne
        @JoinColumn(name = "topico_id")
        val topico: Topico = Topico(),

        @Column(name = "data_criacao")
        val dataCriacao: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        @JoinColumn(name = "autor_id")
        val autor: Usuario = Usuario(),

        @Column(name = "solucao")
        val solucacao: Boolean = false
)

fun Resposta.toRespostaDomain(): RespostaDomain {
    return RespostaDomain(
            mensagem = mensagem
    )
}

fun List<Resposta>.toDomain(): List<RespostaDomain> {
    return map { it.toRespostaDomain() }
}