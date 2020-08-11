package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.controllers.mappers.TopicoMapper
import com.spring.and.kotlin.springAndKotlin.services.TopicoService
import org.springframework.data.domain.Page
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

    @GetMapping
    fun topicos(
            @RequestParam pagina: Int,
            @RequestParam quantidade: Int
    ): Page<TopicoResponseDTO> {
        val findAll = topicoService.buscaTodosOsTopicos(pagina, quantidade)

        return topicoMapper.toDTO(findAll)
    }

    @GetMapping("/{id}")
    fun buscaPorUmTopico(@PathVariable id: Long): ResponseEntity<TopicoResponseDTO> {
        val topico = topicoService.buscaUmTopico(id)
        val dto = topicoMapper.toDTO(topico)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @GetMapping("/nomeCurso")
    fun filtraTopicosPorNomeDoCurso(
            @RequestParam nomeDoCurso: String,
            @RequestParam pagina: Int,
            @RequestParam quantidade: Int
    ): Page<TopicoResponseDTO> {
        val filtraTopicosPorNomeDoCurso = topicoService.filtraTopicosPorNomeDoCurso(nomeDoCurso, pagina, quantidade)

        return topicoMapper.toDTO(filtraTopicosPorNomeDoCurso)
    }

    @PostMapping
    fun cadastrarNovoTopico(
            @RequestBody topicoRequestDTO: TopicoRequestDTO,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoResponseDTO> {
        val novoTopicoCadastrado = topicoService.cadastrarNovoTopico(topicoMapper.toDomain(topicoRequestDTO))
        val dto = topicoMapper.toDTO(novoTopicoCadastrado)

        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dto.id).toUri()
        return ResponseEntity.created(uri).body(dto)
    }

    @PutMapping("/{id}")
    fun atualizarTopico(
            @PathVariable id: Long,
            @RequestBody topicoRequestDTO: TopicoRequestDTO
    ): ResponseEntity<TopicoResponseDTO> {

        val domain = topicoMapper.toDomain(topicoRequestDTO)
        val topicoAtualizado = topicoService.atualizarTopico(id, domain)
        val dto = topicoMapper.toDTO(topicoAtualizado)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @DeleteMapping("/{id}")
    fun atualizarTopico(@PathVariable id: Long): ResponseEntity.BodyBuilder {
        topicoService.deleteTopico(id)
        return ResponseEntity.ok()
    }

    fun magnify(a: Int) = a
    fun add(a: Int, b: Int) = a + magnify(b)
    fun divide(a: Int, b: Int) = a / b
}