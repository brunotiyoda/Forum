package com.spring.and.kotlin.springAndKotlin.services

import com.spring.and.kotlin.springAndKotlin.repositories.TopicoRepository
import com.spring.and.kotlin.springAndKotlin.repositories.entities.Curso
import com.spring.and.kotlin.springAndKotlin.repositories.entities.Topico
import com.spring.and.kotlin.springAndKotlin.repositories.entities.enums.StatusTopico
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.isNull
import java.time.LocalDateTime

class TopicoServiceTest {

    private val topicoRepositoryMockK = mockk<TopicoRepository>()
    private val topicoService = TopicoService(topicoRepositoryMockK)

    @Test
    fun `filter topicos by nome do curso`() {
        val nomeDoCurso = "Spring"

        val topicos: MutableList<Topico> = mutableListOf()

        val topico = Topico(
                id = 1,
                titulo = "Dúvida",
                mensagem = "asdf",
                dataCriacao = LocalDateTime.of(2020, 9, 30, 5, 23),
                statusTopido = StatusTopico.NAO_RESPONDIDO,
                curso = Curso(id = 1, nome = "Spring")
        )

        topicos.add(topico)

        every { topicoRepositoryMockK.findByCurso_Nome(nomeDoCurso) } returns topicos

        val filtraTopicosPorNomeDoCurso = topicoService.filtraTopicosPorNomeDoCurso(nomeDoCurso)

        val nomeCurso = filtraTopicosPorNomeDoCurso.map { it.cursoDomain?.nome }.first()

        assertNotNull(filtraTopicosPorNomeDoCurso)
        assertEquals("Spring", nomeCurso)
        assertFalse(filtraTopicosPorNomeDoCurso.isEmpty())

        verify {
            topicoService.filtraTopicosPorNomeDoCurso(nomeDoCurso)
            topicoRepositoryMockK.findByCurso_Nome(nomeDoCurso)
        }
    }

    @Test
    fun `filter topicos when nome is null`() {
        every { topicoRepositoryMockK.findByCurso_Nome(isNull()) } throws RuntimeException("Something went wrong. Nome is null")

        val filtraTopicosPorNomeDoCurso = topicoService.filtraTopicosPorNomeDoCurso("isNull()")

        val nomeCurso = filtraTopicosPorNomeDoCurso.map { it.cursoDomain?.nome }.first()

        assertNotNull(filtraTopicosPorNomeDoCurso)
        assertEquals("Spring", nomeCurso)
        assertFalse(filtraTopicosPorNomeDoCurso.isEmpty())

        verify {
            topicoService.filtraTopicosPorNomeDoCurso(isNull())
            topicoRepositoryMockK.findByCurso_Nome(isNull())
        }

        verify { topicoRepositoryMockK wasNot Called }
    }

}