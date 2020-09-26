package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.toDomain
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.domains.toResponseDTO
import com.spring.and.kotlin.springAndKotlin.services.TopicoService
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topicos")
class TopicoController(
        private val topicoService: TopicoService
) {
    private val logger = LoggerFactory.getLogger(TopicoController::class.java)

    @GetMapping
    @Cacheable(value = ["listaDeTopicos"])
    fun topicos(@PageableDefault(
            page = 0,
            size = 10,
            sort = ["id"],
            direction = Sort.Direction.ASC
    ) pageable: Pageable): Page<TopicoResponseDTO> {
        logger.info("[TOPICO] - Find all Topicos pageable. Page number: ${pageable.pageNumber} Page size: ${pageable.pageSize}")

        val pageOfTopicoDomain = topicoService.buscaTodosOsTopicos(pageable)

        return pageOfTopicoDomain.toResponseDTO()
    }

    @GetMapping("/{id}")
    fun buscaPorUmTopico(@PathVariable id: Long): ResponseEntity<TopicoResponseDTO> {
        logger.info("[TOPICO] - Find Topico by ID: $id")

        val topicoDomain = topicoService.buscaUmTopico(id)
        val dto = topicoDomain.toResponseDTO()

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @GetMapping("/nomeCurso")
    fun filtraTopicosPorNomeDoCurso(@RequestParam nomeDoCurso: String): List<TopicoResponseDTO> {
        logger.info("[TOPICO] - Filter Topico by name: $nomeDoCurso")

        val filtraTopicosPorNomeDoCurso =
                topicoService.filtraTopicosPorNomeDoCurso(nomeDoCurso)

        return filtraTopicosPorNomeDoCurso.toResponseDTO()
    }

    @PostMapping
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun cadastrarNovoTopico(
            @RequestBody topicoRequestDTO: TopicoRequestDTO,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoResponseDTO> {
        logger.info("[TOPICO] - New Topico: $topicoRequestDTO")

        val novoTopicoCadastrado = topicoService.cadastrarNovoTopico(topicoRequestDTO.toDomain())
        val dto = novoTopicoCadastrado.toResponseDTO()

        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dto.id).toUri()
        return ResponseEntity.created(uri).body(dto)
    }

    @PutMapping("/{id}")
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun atualizarTopico(
            @PathVariable id: Long,
            @RequestBody topicoRequestDTO: TopicoRequestDTO
    ): ResponseEntity<TopicoResponseDTO> {
        logger.info("[TOPICO] - Update a Topico by ID: $id")

        val domain = topicoRequestDTO.toDomain()
        val topicoAtualizado = topicoService.atualizarTopico(id, domain)
        val dto = topicoAtualizado.toResponseDTO()

        return ResponseEntity.ok().body(dto)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun deleteTopico(@PathVariable id: Long): ResponseEntity<Unit> {
        logger.info("[TOPICO] - Delete a Topico by ID: $id")

        topicoService.deleteTopico(id)
        return ResponseEntity.ok().build<Unit>()
    }

    fun magnify(a: Int) = a
    fun add(a: Int, b: Int) = a + magnify(b)
    fun divide(a: Int, b: Int) = a / b
}