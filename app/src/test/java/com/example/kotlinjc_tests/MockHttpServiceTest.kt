package com.example.kotlinjc_tests

import com.example.kotlinjc_tests.services.MockHttpService
import com.example.kotlinjc_tests.utils.mockData
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith

class MockHttpServiceTest {

    @Test
    fun `test MockHttpService Success`() = runTest {
        val encodedData = Json.encodeToString(mockData)
        val mockHttpService = MockHttpService(data = encodedData)
        val data = mockHttpService.fetchData()

        assertEquals(data, mockData)
    }

    @Test
    fun `test MockHttpService Error throw`() = runTest {
        val mockHttpService = MockHttpService(throwError = true)

        assertFailsWith<Exception> {
            mockHttpService.fetchData()
        }
    }
}