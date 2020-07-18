package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.ListOfTopicoResponseDTO
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
    fun topicos(): ResponseEntity<ListOfTopicoResponseDTO> {
        val findAll = topicoService.buscaTodosOsTopicos()
        val dto = topicoMapper.toDTO(findAll)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }


    @GetMapping("/nomeCurso")
    fun filtraTopicosPorNomeDoCurso(nomeDoCurso: String): ResponseEntity<TopicoResponseDTO> {
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

    @GetMapping("/{id}")
    fun buscaPorUmTopico(@PathVariable id: Long): ResponseEntity<TopicoResponseDTO> {
        val topico = topicoService.buscaUmUnicoTopico(id)
        val dto = topicoMapper.toDTO(topico)

        return ResponseEntity.status(HttpStatus.OK).body(dto)
    }

}