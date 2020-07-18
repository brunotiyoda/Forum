package com.spring.and.kotlin.springAndKotlin.entities

import com.spring.and.kotlin.springAndKotlin.entities.enums.StatusTopico
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico(

        @Column(name = "titulo")
        val titulo: String = String(),

        @Column(name = "mensagem")
        val mensagem: String = String(),

        @Column(name = "data_criacao")
        val dataCriacao: LocalDateTime = LocalDateTime.now(),

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        val statusTopido: StatusTopico = StatusTopico.NAO_RESPONDIDO,

        @ManyToOne(cascade = [CascadeType.PERSIST])
        val autor: Usuario = Usuario(),

        @ManyToOne(cascade = [CascadeType.PERSIST])
        val curso: Curso = Curso()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToMany(mappedBy = "topico")
    val respostas: MutableList<Resposta> = mutableListOf()

}