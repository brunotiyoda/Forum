package com.spring.and.kotlin.springAndKotlin.controllers.dtos.response

class ListOfTopicoResponseDTO {
    private var topicoResponses: MutableList<TopicoResponseDTO> = mutableListOf()

    fun add(topicoResponseDTO: TopicoResponseDTO) {
        topicoResponses.plus(topicoResponseDTO)
    }

}