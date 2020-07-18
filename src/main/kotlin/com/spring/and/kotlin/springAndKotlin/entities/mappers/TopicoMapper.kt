package com.spring.and.kotlin.springAndKotlin.entities.mappers

import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.entities.Topico
import org.springframework.stereotype.Component

@Component
class TopicoMapper(
        private val cursoMapper: CursoMapper = CursoMapper()
) {

    fun toDomain(sources: List<Topico>): TopicoDomain {
        var topicoDomain = TopicoDomain.Builder().build()
        for (source in sources) {
            topicoDomain = TopicoDomain.Builder()
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
        return topicoDomain
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

    fun toEntity(source: TopicoDomain): Topico {
        return Topico(
                titulo = source.titulo,
                mensagem = source.mensagem,
                curso = cursoMapper.toEntity(source.cursoDomain)
        )
    }
}