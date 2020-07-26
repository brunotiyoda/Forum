package com.spring.and.kotlin.springAndKotlin.entities.mappers

import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.entities.Topico
import org.springframework.stereotype.Component
import java.util.*

@Component
class TopicoMapper(
        private val cursoMapper: CursoMapper = CursoMapper()
) {

    fun toDomain(sources: List<Topico>): MutableList<TopicoDomain> {
        val topicosDomain: MutableList<TopicoDomain> = mutableListOf()

        for (source in sources) {
            val topicoDomain = TopicoDomain.Builder()
                    .withId(source.id)
                    .withTitulo(source.titulo)
                    .withMensagem(source.mensagem)
                    .withCursoDomain(
                            CursoDomain.Builder()
                                    .withNome(source.curso.nome)
                                    .build()
                    )
                    .build()
            topicosDomain.add(topicoDomain)
        }

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