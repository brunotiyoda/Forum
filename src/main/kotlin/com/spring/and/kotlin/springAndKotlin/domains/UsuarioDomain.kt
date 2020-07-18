package com.spring.and.kotlin.springAndKotlin.domains


class UsuarioDomain(
        val id: Long,
        val nome: String,
        val email: String,
        val senha: String
) {

    class Builder(
            var id: Long = 0,
            var nome: String = "",
            var email: String = "",
            var senha: String = ""
    ) {
        fun withId(id: Long) = apply { this.id = id }
        fun withNome(nome: String) = apply { this.nome = nome }
        fun withEmail(email: String) = apply { this.email = email }
        fun withSenha(senha: String) = apply { this.senha = senha }
        fun build() = UsuarioDomain(id, nome, email, senha)
    }

}
