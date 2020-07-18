package com.spring.and.kotlin.springAndKotlin.entities.mappers

import com.spring.and.kotlin.springAndKotlin.domains.CursoDomain
import com.spring.and.kotlin.springAndKotlin.entities.Curso
import org.springframework.stereotype.Component

@Component
class CursoMapper {

    fun toDomain(source: Curso) {}

    fun toEntity(source: CursoDomain): Curso {
        return Curso(nome = source.nome)
    }
}