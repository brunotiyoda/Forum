package com.spring.and.kotlin.springAndKotlin.domains

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.AutorResponseDTO
import com.spring.and.kotlin.springAndKotlin.repositories.entities.Usuario

data class UsuarioDomain(
        val id: Long? = 0,
        val nome: String? = "",
        val email: String? = "",
        val senha: String? = ""
)

fun UsuarioDomain.toEntity(): Usuario {
    return Usuario(
            id = id,
            nome = nome!!,
            email = email!!,
            senha = senha!!
    )
}

fun UsuarioDomain.toResponseDTO(): AutorResponseDTO {
    return AutorResponseDTO(
            nome = nome
    )
}
