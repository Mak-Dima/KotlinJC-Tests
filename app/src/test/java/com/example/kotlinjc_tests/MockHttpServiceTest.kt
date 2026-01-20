package com.example.kotlinjc_tests

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.kotlinjc_tests.services.MockHttpService
import com.example.kotlinjc_tests.utils.mockData
import kotlinx.serialization.json.Json

class MockHttpServiceTest {

    @Test
    fun `test MockHttpService Success`() = runTest {
        val encodedData = Json.encodeToString(mockData)
        val mockHttpService = MockHttpService(data = encodedData)
        val data = mockHttpService.fetchData()

        assertEquals(data, mockData)
    }

}