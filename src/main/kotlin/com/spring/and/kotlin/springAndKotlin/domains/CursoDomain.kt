package com.spring.and.kotlin.springAndKotlin.domains

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.CursoResponseDTO
import com.spring.and.kotlin.springAndKotlin.repositories.entities.Curso

class CursoDomain(
        val id: Long? = 0,
        val nome: String = "",
        val categoria: String = ""
)

fun CursoDomain.toEntity(): Curso {
    return Curso(
            id = id,
            nome = nome,
            categoria = categoria
    )
}

fun CursoDomain.toResponseDTO(): CursoResponseDTO {
    return CursoResponseDTO(
            nome = nome,
            categoria = categoria
    )
}