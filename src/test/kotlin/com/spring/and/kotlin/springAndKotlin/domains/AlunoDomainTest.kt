package com.spring.and.kotlin.springAndKotlin.domains

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

class AlunoDomainTest {

    @Test
    fun `deve contruir o dominio de Aluno`() {
        val alunoDomain = AlunoDomain.Builder()
                .withId(1)
                .withNome("Bruno")
                .withDataDeCriacao(LocalDate.of(2020, Month.JULY, 11))
                .build()

        assertNotNull(alunoDomain)
        assertNotNull(alunoDomain.id)
        assertNotNull(alunoDomain.nome)
        assertNotNull(alunoDomain.dataDeCriacao)
        assertEquals(1, alunoDomain.id)
        assertEquals("Bruno", alunoDomain.nome)
        assertEquals(LocalDate.of(2020, Month.JULY, 11), alunoDomain.dataDeCriacao)
    }

}