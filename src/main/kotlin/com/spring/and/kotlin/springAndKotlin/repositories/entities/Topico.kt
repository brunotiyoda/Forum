package com.spring.and.kotlin.springAndKotlin.repositories.entities

import com.spring.and.kotlin.springAndKotlin.domains.TopicoDomain
import com.spring.and.kotlin.springAndKotlin.repositories.entities.enums.StatusTopico
import org.springframework.data.domain.Page
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Topico(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @Column(name = "titulo")
        var titulo: String = String(),

        @Column(name = "mensagem")
        var mensagem: String = String(),

        @Column(name = "data_criacao")
        val dataCriacao: LocalDateTime? = LocalDateTime.now(),

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        val statusTopido: StatusTopico = StatusTopico.NAO_RESPONDIDO,

        @ManyToOne(cascade = [CascadeType.PERSIST])
        val autor: Usuario = Usuario(),

        @ManyToOne(cascade = [CascadeType.PERSIST])
        val curso: Curso = Curso(),

        @OneToMany(mappedBy = "topico")
        val respostas: List<Resposta>? = emptyList()
)

fun Topico.toDomain(): TopicoDomain {
    return TopicoDomain(
            id = id,
            titulo = titulo,
            mensagem = mensagem,
            dataCriacao = dataCriacao,
            statusTopico = statusTopido,
            autorDomain = autor.toDomain(),
            cursoDomain = curso.toDomain(),
            respostasDomain = respostas?.toDomain()
    )
}

fun List<Topico>.toDomain(): List<TopicoDomain> {
    return map { it.toDomain() }
}

fun Page<Topico>.toPageDomain(): Page<TopicoDomain> {
    return map { it.toDomain() }
}

fun Optional<Topico>.toDomain(): TopicoDomain {
        return map { get().toDomain() }.orElseThrow { throw Exception("Não encontrado") }
}