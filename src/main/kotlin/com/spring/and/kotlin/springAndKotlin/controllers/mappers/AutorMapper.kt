package com.spring.and.kotlin.springAndKotlin.controllers.mappers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.AutorResponseDTO
import com.spring.and.kotlin.springAndKotlin.domains.UsuarioDomain

class AutorMapper {

    fun toDTO(source: UsuarioDomain): AutorResponseDTO {
        val autorDTO = AutorResponseDTO()

        autorDTO.nome = source.nome

        return autorDTO
    }

}
