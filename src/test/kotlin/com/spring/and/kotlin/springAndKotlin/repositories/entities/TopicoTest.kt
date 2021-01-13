package com.spring.and.kotlin.springAndKotlin.repositories.entities

import com.spring.and.kotlin.springAndKotlin.repositories.entities.enums.StatusTopico
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class TopicoTest {

    val topico = Topico(
            id = 1,
            titulo = "Dúvida",
            mensagem = "asdf",
            dataCriacao = LocalDateTime.of(2020, 9, 30, 5, 23),
            statusTopido = StatusTopico.NAO_RESPONDIDO,
            autor = Usuario(
                    id = 1,
                    nome = "Bruno",
                    email = "email@email.com",
                    senha = "123456",
                    perfis = listOf(Perfil(tipo = "Aluno"))
            ),
            curso = Curso(id = 1, nome = "Spring", categoria = "Java"),
            respostas = listOf(Resposta(
                    id = 1,
                    mensagem = "mensagem",
                    dataCriacao = LocalDateTime.of(2020, 9, 30, 5, 30),
                    autor = Usuario(
                            id = 1,
                            nome = "Bruno",
                            email = "email@email.com",
                            senha = "123456",
                            perfis = listOf(Perfil(tipo = "Aluno"))
                    ),
                    solucacao = false
            ))
    )

    @Test
    fun `should convert to domain`() {
        val domain = topico.toDomain()

        assertNotNull(domain)
        assertEquals("Bruno", domain.autorDomain?.nome)
    }

    @Test
    fun `should convert to list domain`() {
        val topicos = listOf(topico)

        val domains = topicos.toDomain()

        val nome = domains.map { it.autorDomain?.nome }.first()

        assertNotNull(domains)
        assertEquals("Bruno", nome)
    }

    @Test
    fun `should convert from Optional Topico`() {
        val optionalTopico = Optional.of(topico)

        val domain = optionalTopico.toDomain()

        assertNotNull(domain)
        assertEquals("Bruno", domain.autorDomain?.nome)
    }

    @Test
    fun `should ??? from Optional Topico when is null`() {
        val optionalTopico = Optional.of(Topico())

        val domain = optionalTopico.toDomain()

        assertNotNull(domain)
        assertEquals("", domain.autorDomain?.nome)
    }

}