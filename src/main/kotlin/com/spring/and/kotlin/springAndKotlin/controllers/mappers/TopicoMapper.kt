package com.spring.and.kotlin.springAndKotlin.controllers.mappers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.ListOfTopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import org.springframework.stereotype.Component

@Component("topicoMapperDTO")
class TopicoMapper {
    var listOfTopicoResponseDTO: ListOfTopicoResponseDTO = ListOfTopicoResponseDTO()
    var autorMapper: AutorMapper = AutorMapper()
    var cursoMapper: CursoMapper = CursoMapper()

    fun toDTO(sources: List<TopicoDomain>): ListOfTopicoResponseDTO {
        val topicoDTO = TopicoResponseDTO()

        for (source in sources) {
            topicoDTO.id = source.id
            topicoDTO.titulo = source.titulo
            topicoDTO.mensagem = source.mensagem
            topicoDTO.dataCriacao = source.dataCriacao
            topicoDTO.statusTopido = source.statusTopidoDomain
            topicoDTO.autorResponse = autorMapper.toDTO(source.autor)
            topicoDTO.cursoResponse = cursoMapper.toDTO(source.cursoDomain)
            listOfTopicoResponseDTO.add(topicoDTO)
        }

        return listOfTopicoResponseDTO
    }

    fun toDTO(source: TopicoDomain): TopicoResponseDTO {
        val topicoDTO = TopicoResponseDTO()
        topicoDTO.id = source.id
        topicoDTO.titulo = source.titulo
        topicoDTO.mensagem = source.mensagem
        topicoDTO.dataCriacao = source.dataCriacao
        topicoDTO.statusTopido = source.statusTopidoDomain
        topicoDTO.autorResponse = autorMapper.toDTO(source.autor)
        topicoDTO.cursoResponse = cursoMapper.toDTO(source.cursoDomain)

        return topicoDTO
    }

    fun toDomain(source: TopicoRequestDTO): TopicoDomain {
        return TopicoDomain.Builder()
                .withTitulo(source.titulo)
                .withMensagem(source.mensagem)
                .withCursoDomain(
                        CursoDomain.Builder()
                                .withNome(source.nomeCurso)
                                .build()
                )
                .build()
    }

}