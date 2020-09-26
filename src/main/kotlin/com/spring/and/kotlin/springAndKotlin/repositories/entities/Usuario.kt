package com.spring.and.kotlin.springAndKotlin.repositories.entities

import com.spring.and.kotlin.springAndKotlin.domains.UsuarioDomain
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
data class Usuario(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @Column(name = "nome")
        val nome: String = "",

        @Column(name = "email")
        val email: String = "",

        @Column(name = "senha")
        val senha: String = "",

        @OneToMany(fetch = FetchType.EAGER)
        val perfis: List<Perfil> = emptyList()

) : UserDetails {

    override fun getAuthorities(): List<GrantedAuthority> {
        return perfis
    }

    override fun getPassword(): String {
        return senha
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

fun Usuario.toDomain(): UsuarioDomain {
    return UsuarioDomain(
            nome = nome
    )
}