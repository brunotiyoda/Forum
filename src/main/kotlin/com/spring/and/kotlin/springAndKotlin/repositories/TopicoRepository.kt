package com.spring.and.kotlin.springAndKotlin.repositories

import com.spring.and.kotlin.springAndKotlin.entities.Topico
import org.springframework.data.jpa.repository.JpaRepository

open interface TopicoRepository : JpaRepository<Topico, Long> {

    fun findByCurso_Nome(nomeDoCurso: String): MutableList<Topico>
}