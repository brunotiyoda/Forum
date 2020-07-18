package com.spring.and.kotlin.springAndKotlin.entities

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Aluno(

        @Column(name = "nome")
        var nome: String = String()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0

    var dataDeCriacao: LocalDate = LocalDate.now()

}