package com.moviebox.backend

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/") {}.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Test", response.content)
            }
        }
    }

    @Test
    fun testRegister() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Post, "/users") {}.apply {
                assertEquals(HttpStatusCode.Unauthorized, response.status())
            }
        }
    }
}