package com.spring.and.kotlin.springAndKotlin.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(

        @Column(name = "mensagem")
        var mensagem: String = String(),

        @ManyToOne
        @JoinColumn(name = "topico_id")
        var topico: Topico = Topico(),

        @Column(name = "data_criacao")
        var dataCriacao: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        @JoinColumn(name = "autor_id")
        var autor: Usuario = Usuario(),

        @Column(name = "solucao")
        var solucacao: Boolean = false
) {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0

}
