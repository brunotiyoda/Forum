package com.spring.and.kotlin.springAndKotlin.controllers

import io.mockk.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicoControllerTest {

    val topicoControllerMockk = mockk<TopicoController>()

/*    @Autowired
    private lateinit var topicoController: TopicoController*/

/*    @InjectMocks
    private lateinit var topicoService: TopicoService

    @Mock
    private lateinit var topicoRepository: TopicoRepository

    @InjectMocks
    private lateinit var topicoMapper: TopicoMapper*/

    //private lateinit var topicoMapper2: com.spring.and.kotlin.springAndKotlin.entities.mappers.TopicoMapper


    @Test
    fun `deve atualizar um tópico`() {

        every { topicoControllerMockk.atualizarTopico(1) } returns ResponseEntity.ok()

        topicoControllerMockk.atualizarTopico(1)

        verify { topicoControllerMockk.atualizarTopico(1) }

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
