package com.spring.and.kotlin.springAndKotlin.services

import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.entities.mappers.TopicoMapper
import com.spring.and.kotlin.springAndKotlin.repositories.TopicoRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicoService(
        private val topicoRepository: TopicoRepository,
        private val topicoMapper: TopicoMapper
) {

    private val logger = LoggerFactory.getLogger(TopicoService::class.java)

    fun buscaTodosOsTopicos(pagination: Pageable): Page<TopicoDomain> {
        val findAll = topicoRepository.findAll(pagination)
        logger.info("topicos found $findAll")

        return topicoMapper.toDomain(findAll)
    }

    fun buscaUmTopico(id: Long): TopicoDomain {
        val found = topicoRepository.findById(id)
        logger.info("topico found $found")

        return topicoMapper.toDomain(found)
    }

    fun filtraTopicosPorNomeDoCurso(nomeDoCurso: String): List<TopicoDomain> {
        val nomeDoCurso = topicoRepository.findByCurso_Nome(nomeDoCurso)
        logger.info("topico found $nomeDoCurso")

        return topicoMapper.toDomain(nomeDoCurso)
    }

    fun cadastrarNovoTopico(topicoDomain: TopicoDomain): TopicoDomain {
        val entity = topicoMapper.toEntity(topicoDomain)
        logger.info("new topico domain to entity $entity")

        val save = topicoRepository.save(entity)
        logger.info("new topico $save")

        return topicoMapper.toDomain(save)
    }

    fun atualizarTopico(id: Long, topicoDomain: TopicoDomain): TopicoDomain {
        logger.info("update a topico $id ${topicoDomain.titulo}")

        val found = topicoRepository.getOne(id)
        logger.info("topico found ${found.id} ${found.titulo}")

        val entity = topicoMapper.udpateTopico(found, topicoDomain)
        logger.info("update topico domain to entity $entity")

        val save = topicoRepository.save(entity)
        logger.info("update topico $save")

        return topicoMapper.toDomain(save)
    }

    fun deleteTopico(id: Long) {
        logger.info("delete a topico $id")
        topicoRepository.deleteById(id)
    }

}