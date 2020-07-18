package com.spring.and.kotlin.springAndKotlin.controllers.mappers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.CursoResponseDTO
import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import org.springframework.stereotype.Component

@Component("cursoMapperDTO")
class CursoMapper {

    fun toDTO(source: CursoDomain): CursoResponseDTO {
        val cursoDTO = CursoResponseDTO()

        cursoDTO.nome = source.nome
        cursoDTO.categoria = source.categoria

        return cursoDTO
    }

}
