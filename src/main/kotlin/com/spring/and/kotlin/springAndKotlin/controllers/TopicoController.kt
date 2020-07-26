package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.controllers.mappers.TopicoMapper
import com.spring.and.kotlin.springAndKotlin.services.TopicoService
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
    fun topicos(): ResponseEntity<List<TopicoResponseDTO>> {
        val findAll = topicoService.buscaTodosOsTopicos()
        val dto = topicoMapper.toDTO(findAll)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @GetMapping("/{id}")
    fun buscaPorUmTopico(@PathVariable id: Long): ResponseEntity<TopicoResponseDTO> {
        val topico = topicoService.buscaUmTopico(id)
        val dto = topicoMapper.toDTO(topico)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

    @GetMapping("/nomeCurso")
    fun filtraTopicosPorNomeDoCurso(nomeDoCurso: String): ResponseEntity<List<TopicoResponseDTO>> {
        val filtraTopicosPorNomeDoCurso = topicoService.filtraTopicosPorNomeDoCurso(nomeDoCurso)
        val dto = topicoMapper.toDTO(filtraTopicosPorNomeDoCurso)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
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
    fun atualizarTopico(@PathVariable id: Long): ResponseEntity<TopicoResponseDTO> {
        topicoService.deleteTopico(id)
        return ResponseEntity.ok().build()
    }

}