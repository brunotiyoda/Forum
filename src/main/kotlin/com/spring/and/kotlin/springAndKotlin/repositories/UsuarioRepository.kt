package com.spring.and.kotlin.springAndKotlin.repositories

import com.spring.and.kotlin.springAndKotlin.entities.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

}