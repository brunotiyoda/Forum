package com.spring.and.kotlin.springAndKotlin.services

import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.entities.mappers.TopicoMapper
import com.spring.and.kotlin.springAndKotlin.repositories.TopicoRepository
import org.springframework.stereotype.Service

@Service
class TopicoService(
        private val topicoRepository: TopicoRepository,
        private val topicoMapper: TopicoMapper
) {

    fun buscaTodosOsTopicos(): List<TopicoDomain> {
        val findAll = topicoRepository.findAll()
        return listOf(topicoMapper.toDomain(findAll))
    }

    fun buscaUmUnicoTopico(id: Long): TopicoDomain {
        val found = topicoRepository.getOne(id)
        return topicoMapper.toDomain(found)
    }

    fun filtraTopicosPorNomeDoCurso(nomeDoCurso: String): TopicoDomain {
        val cursoDoNome = topicoRepository.findByCurso_Nome(nomeDoCurso)
        return topicoMapper.toDomain(cursoDoNome)
    }

    fun cadastrarNovoTopico(topicoDomain: TopicoDomain): TopicoDomain {
        val entity = topicoMapper.toEntity(topicoDomain)
        val save = topicoRepository.save(entity)

        return topicoMapper.toDomain(save)
    }
}