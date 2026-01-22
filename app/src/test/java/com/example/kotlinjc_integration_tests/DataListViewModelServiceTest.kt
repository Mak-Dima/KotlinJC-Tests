package com.example.kotlinjc_integration_tests

import com.example.kotlinjc_tests.services.MockHttpService
import com.example.kotlinjc_tests.utils.ViewState
import com.example.kotlinjc_tests.utils.mockData
import com.example.kotlinjc_tests.viewModels.DataListViewModel
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Test
import kotlin.test.assertNotNull

class DataListViewModelServiceTest {

    @Test
    fun `Test DataListViewModel Success data loading`() = runTest {
        val encodedData = Json.encodeToString(mockData)
        val service = MockHttpService(data = encodedData)
        val vm = DataListViewModel(service)

        vm.loadData()

        val actualData = vm.data
        assert(actualData == mockData)
        assert(vm.state == ViewState.READY)
    }

    @Test
    fun `Test DataListViewModel Error data loading`() = runTest {
        val service = MockHttpService(throwError = true)
        val vm = DataListViewModel(service)

        vm.loadData()

        assert(vm.state == ViewState.ERROR)
        assertNotNull(vm.errorMsg)
    }
}