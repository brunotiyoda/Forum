package com.spring.and.kotlin.springAndKotlin.entities

import javax.persistence.*

@Entity
data class Curso(

        @Column(name = "nome")
        var nome: String = String(),

        @Column(name = "categoria")
        var categoria: String = String()
) {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0
}
