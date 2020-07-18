package com.spring.and.kotlin.springAndKotlin.domains

class CursoDomain(
        val id: Long,
        val nome: String,
        val categoria: String
) {

    class Builder(
            var id: Long = 0,
            var nome: String = "",
            var categoria: String = ""
    ) {
        fun withId(id: Long) = apply { this.id = id }
        fun withNome(nome: String) = apply { this.nome = nome }
        fun withCategoria(categoria: String) = apply { this.categoria = categoria }
        fun build() = CursoDomain(id, nome, categoria)
    }
}
