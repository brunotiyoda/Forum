package com.spring.and.kotlin.springAndKotlin.repositories

import com.spring.and.kotlin.springAndKotlin.entities.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {

}