package com.spring.and.kotlin.springAndKotlin.controllers.mappers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import org.springframework.stereotype.Component

@Component("topicoMapperDTO")
class TopicoMapper(
        val autorMapper: AutorMapper = AutorMapper(),
        val cursoMapper: CursoMapper = CursoMapper()
) {

    fun toDTO(sources: List<TopicoDomain>): MutableList<TopicoResponseDTO> {
        val listOfTopicoResponseDTO: MutableList<TopicoResponseDTO> = mutableListOf()

        for (source in sources) {
            val topicoDTO = toDTO(source)
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