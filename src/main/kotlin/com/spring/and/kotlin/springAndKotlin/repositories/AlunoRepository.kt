package com.spring.and.kotlin.springAndKotlin.repositories

import com.spring.and.kotlin.springAndKotlin.entities.Aluno
import org.springframework.data.jpa.repository.JpaRepository

interface AlunoRepository : JpaRepository<Aluno, Long> {

}