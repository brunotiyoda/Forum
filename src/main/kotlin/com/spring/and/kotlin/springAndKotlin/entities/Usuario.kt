package com.spring.and.kotlin.springAndKotlin.entities

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
data class Usuario(

        @Column(name = "nome")
        val nome: String = "",

        @Column(name = "email")
        val email: String = "",

        @Column(name = "senha")
        val senha: String = ""
) : UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @OneToMany(fetch = FetchType.EAGER)
    val perfis: MutableList<Perfil> = mutableListOf()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
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
