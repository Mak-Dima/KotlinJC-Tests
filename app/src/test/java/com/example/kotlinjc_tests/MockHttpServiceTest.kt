package com.example.kotlinjc_tests

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.kotlinjc_tests.services.MockHttpService
import com.example.kotlinjc_tests.utils.mockData

class MockHttpServiceTest {

    @Test
    fun `test MockHttpService Success`() = runTest {
        val mockHttpService = MockHttpService()
        val data = mockHttpService.fetchData()

        assertEquals(data, mockData)
    }

}