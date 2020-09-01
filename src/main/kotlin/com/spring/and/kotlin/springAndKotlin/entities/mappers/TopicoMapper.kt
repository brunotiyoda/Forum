package com.spring.and.kotlin.springAndKotlin.entities.mappers

import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.entities.Topico
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors

@Component
class TopicoMapper(
        private val cursoMapper: CursoMapper = CursoMapper()
) {

    fun toDomain(pages: Page<Topico>): Page<TopicoDomain> {
        return pages.map { page -> toDomain(page) }
    }

    fun toDomain(topicos: List<Topico>): List<TopicoDomain> {
        val topicosDomain: MutableList<TopicoDomain> = mutableListOf()

        topicos.stream().map { topico ->
            topicosDomain.add(toDomain(topico))
        }.collect(Collectors.toList())

        return topicosDomain
    }

    fun toDomain(source: Topico): TopicoDomain {
        return TopicoDomain.Builder()
                .withId(source.id)
                .withTitulo(source.titulo)
                .withMensagem(source.mensagem)
                .withCursoDomain(
                        CursoDomain.Builder()
                                .withNome(source.curso.nome)
                                .build()
                )
                .build()
    }

    fun toDomain(source: Optional<Topico>): TopicoDomain {
        return source.map { toDomain(source.get()) }.orElseThrow { throw Exception("Não encontrado") }
    }


    fun toEntity(source: TopicoDomain): Topico {
        return Topico(
                titulo = source.titulo,
                mensagem = source.mensagem,
                curso = cursoMapper.toEntity(source.cursoDomain)
        )
    }

    fun udpateTopico(source: Topico, topicoDomain: TopicoDomain): Topico {
        source.titulo = topicoDomain.titulo
        source.mensagem = topicoDomain.mensagem

        return source
    }

}