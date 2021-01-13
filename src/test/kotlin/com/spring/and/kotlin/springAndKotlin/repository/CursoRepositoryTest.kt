package com.spring.and.kotlin.springAndKotlin.repository

import com.spring.and.kotlin.springAndKotlin.repositories.CursoRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class CursoRepositoryTest(
        @Autowired private val cursoRepository: CursoRepository
) {

    @Test
    fun `loads a course when searching by name`() {
        val name = "Spring Boot"

        val findByNome = cursoRepository.findByNome(name)

        assertNotNull(findByNome)
        assertEquals(name, findByNome!!.nome)
    }


    @Test
    fun `course no content`() {
        val name = "JPA"

        val findByNome = cursoRepository.findByNome(name)

        assertNull(findByNome)
    }
}