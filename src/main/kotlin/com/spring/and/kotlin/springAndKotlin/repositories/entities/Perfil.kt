package com.spring.and.kotlin.springAndKotlin.repositories.entities

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
data class Perfil(

        @Column(name = "tipo")
        val tipo: String = ""
) : GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    override fun getAuthority(): String {
        return tipo
    }

}
