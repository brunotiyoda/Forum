package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.dtos.request.TopicoRequestDTO
import com.spring.and.kotlin.springAndKotlin.controllers.dtos.response.TopicoResponseDTO
import io.mockk.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class TopicoControllerTest {

    val topicoControllerMockk = mockk<TopicoController>()

    @Test
    fun `deve atualizar um tópico`() {

        every { topicoControllerMockk.atualizarTopico(1, TopicoRequestDTO()) } returns ResponseEntity.ok().body(TopicoResponseDTO())

        topicoControllerMockk.atualizarTopico(1, TopicoRequestDTO())

        verify { topicoControllerMockk.atualizarTopico(1, TopicoRequestDTO()) }

        confirmVerified(topicoControllerMockk)
    }


    @Test
    fun `capture an argument`() {

        val slot = slot<Int>()

        every { topicoControllerMockk.divide(capture(slot), any()) } returns 22

        topicoControllerMockk.divide(5, 2)

        assertEquals(5, slot.captured)
    }

    @Test
    fun `spies`() {
        val spy = spyk(topicoControllerMockk)

        assertEquals(9, spy.add(4, 5))

        every { spy.magnify(any()) } answers { firstArg<Int>() * 2 }

        assertEquals(14, spy.add(4, 5))

        verify { spy.add(4, 5) }
        verify { spy.magnify(5) }
    }

}
