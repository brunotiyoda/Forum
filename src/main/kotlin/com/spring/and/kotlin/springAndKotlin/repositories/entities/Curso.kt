package com.spring.and.kotlin.springAndKotlin.repositories.entities

import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import javax.persistence.*

@Entity
data class Curso(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @Column(name = "nome")
        val nome: String = String(),

        @Column(name = "categoria")
        val categoria: String? = String()
)

fun Curso.toDomain(): CursoDomain {
    return CursoDomain(
            nome = nome,
            categoria = categoria!!
    )
}