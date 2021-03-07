package com.spring.and.kotlin.springAndKotlin.services

import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.domains.toEntity
import com.spring.and.kotlin.springAndKotlin.domains.updateTopico
import com.spring.and.kotlin.springAndKotlin.repositories.TopicoRepository
import com.spring.and.kotlin.springAndKotlin.repositories.entities.toDomain
import com.spring.and.kotlin.springAndKotlin.repositories.entities.toPageDomain
import com.spring.and.kotlin.springAndKotlin.services.exceptions.TopicoNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository
) {

    private val logger = LoggerFactory.getLogger(TopicoService::class.java)

    fun buscaTodosOsTopicos(pagination: Pageable): Page<TopicoDomain> {
        val pageOfTopico = topicoRepository.findAll(pagination)
        logger.info("[TOPICO] - Found Topicos: $pageOfTopico")

        return pageOfTopico.toPageDomain()
    }

    fun buscaUmTopico(id: Long): TopicoDomain {
        val optionalOfTopico = topicoRepository.findById(id).orElseThrow { throw TopicoNotFoundException("$id") }
        logger.info("[TOPICO] - Found Topico: ${optionalOfTopico.titulo}")

        return optionalOfTopico.toDomain()
    }

    fun filtraTopicosPorNomeDoCurso(nomeDoCurso: String): List<TopicoDomain> {
        val cursos = topicoRepository.findByCurso_Nome(nomeDoCurso)

        if (cursos.isEmpty()) throw TopicoNotFoundException()

        logger.info("[TOPICO] - Found Topico by Curso: $cursos")

        return cursos.toDomain()
    }

    fun cadastrarNovoTopico(topicoDomain: TopicoDomain): TopicoDomain {
        val entity = topicoDomain.toEntity()
        logger.info("[TOPICO] - New Topico Domain to Entity: $entity")

        val save = topicoRepository.save(entity)
        logger.info("new topico $save")

        return save.toDomain()
    }

    fun atualizarTopico(id: Long, topicoDomain: TopicoDomain): TopicoDomain {
        logger.info("[TOPICO] - Update Topico: $id ${topicoDomain.titulo}")

        val topico = topicoRepository.findById(id).orElseThrow { throw TopicoNotFoundException("$id") }
        logger.info("[TOPICO] - Found Topico: ${topico.id} ${topico.titulo}")

        val entity = topicoDomain.updateTopico(topico)
        logger.info("[TOPICO] - Update Topico Domain to Entity")

        val save = topicoRepository.save(entity)
        logger.info("[TOPICO] - Update Topico")

        return save.toDomain()
    }

    fun deleteTopico(id: Long) {
        logger.info("[TOPICO] - Delete Topico by ID: $id")
        topicoRepository.deleteById(id)
    }

}