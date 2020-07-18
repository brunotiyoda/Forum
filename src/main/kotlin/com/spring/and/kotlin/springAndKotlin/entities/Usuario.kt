package com.spring.and.kotlin.springAndKotlin.entities

import javax.persistence.*

@Entity
data class Usuario(

        @Column(name = "nome")
        var nome: String = String(),

        @Column(name = "email")
        var email: String = String(),

        @Column(name = "senha")
        var senha: String = String()
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

}
