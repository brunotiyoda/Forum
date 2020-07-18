package com.spring.and.kotlin.springAndKotlin.domains

import java.time.LocalDate

class AlunoDomain private constructor(
        val id: Long,
        val nome: String,
        val dataDeCriacao: LocalDate
) {

    class Builder(
            var id: Long = 0,
            var nome: String = String(),
            var dataDeCriacao: LocalDate = LocalDate.now()
    ) {
        fun withId(id: Long) = apply { this.id = id }
        fun withNome(nome: String) = apply { this.nome = nome }
        fun withDataDeCriacao(dataDeCriacao: LocalDate) = apply { this.dataDeCriacao = dataDeCriacao }
        fun build() = AlunoDomain(id, nome, dataDeCriacao)
    }

}

