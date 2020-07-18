/*
package com.spring.and.kotlin.springAndKotlin.controllers

import com.spring.and.kotlin.springAndKotlin.controllers.mappers.TopicoMapper
import com.spring.and.kotlin.springAndKotlin.repositories.TopicoRepository
import com.spring.and.kotlin.springAndKotlin.services.TopicoService
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.web.servlet.MockMvc

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TopicoControllerTest(
        private val mvc: MockMvc,
        private val restTemplate: TestRestTemplate
) {

    @Mock
    private val topicoController = TopicoController(topicoService, topicoMapper)

    @InjectMocks
    private val topicoService = TopicoService(topicoRepository, topicoMapper

    @Mock
    private val topicoRepository = TopicoRepository

    @InjectMocks
    private val topicoMapper = TopicoMapper()

    @Test
    fun `asdf`() {
        restTemplate.
        val response: MockHttpServletResponse = mvc.perform()
    }

}*/
