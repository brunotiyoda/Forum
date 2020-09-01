package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.controllers.mappers.TopicoMapper
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
        private val topicoService: TopicoService,
        private val topicoMapper: TopicoMapper
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
        logger.info("find all topicos pageable. page number ${pageable.pageNumber} page size ${pageable.pageSize}")

        val findAll = topicoService.buscaTodosOsTopicos(pageable)

        return topicoMapper.toDTO(findAll)
    }

    @GetMapping("/{id}")
    fun buscaPorUmTopico(@PathVariable id: Long): ResponseEntity<TopicoResponseDTO> {
        logger.info("find topico by id $id")

        val topico = topicoService.buscaUmTopico(id)
        val dto = topicoMapper.toDTO(topico)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @GetMapping("/nomeCurso")
    fun filtraTopicosPorNomeDoCurso(@RequestParam nomeDoCurso: String): List<TopicoResponseDTO> {
        logger.info("filter topico by name $nomeDoCurso")

        val filtraTopicosPorNomeDoCurso =
                topicoService.filtraTopicosPorNomeDoCurso(nomeDoCurso)

        return topicoMapper.toDTO(filtraTopicosPorNomeDoCurso)
    }

    @PostMapping
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun cadastrarNovoTopico(
            @RequestBody topicoRequestDTO: TopicoRequestDTO,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoResponseDTO> {
        logger.info("new topico $topicoRequestDTO")

        val novoTopicoCadastrado = topicoService.cadastrarNovoTopico(topicoMapper.toDomain(topicoRequestDTO))
        val dto = topicoMapper.toDTO(novoTopicoCadastrado)

        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dto.id).toUri()
        return ResponseEntity.created(uri).body(dto)
    }

    @PutMapping("/{id}")
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun atualizarTopico(
            @PathVariable id: Long,
            @RequestBody topicoRequestDTO: TopicoRequestDTO
    ): ResponseEntity<TopicoResponseDTO> {
        logger.info("update a topico $id")

        val domain = topicoMapper.toDomain(topicoRequestDTO)
        val topicoAtualizado = topicoService.atualizarTopico(id, domain)
        val dto = topicoMapper.toDTO(topicoAtualizado)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["listaDeTopicos"], allEntries = true)
    fun deleteTopico(@PathVariable id: Long): ResponseEntity<Unit> {
        logger.info("delete a topico $id")

        topicoService.deleteTopico(id)
        return ResponseEntity.ok().build<Unit>()
    }

    fun magnify(a: Int) = a
    fun add(a: Int, b: Int) = a + magnify(b)
    fun divide(a: Int, b: Int) = a / b
}