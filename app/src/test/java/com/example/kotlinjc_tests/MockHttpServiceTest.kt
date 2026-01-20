package com.example.kotlinjc_tests

import com.example.kotlinjc_tests.services.MockHttpService
import com.example.kotlinjc_tests.utils.mockData
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MockHttpServiceTest {

    @Test
    fun testMockHttpService() {
        val mockHttpService = MockHttpService()
        runBlocking {
            val data = mockHttpService.fetchData()
            assertEquals(data, mockData)
        }
    }

}