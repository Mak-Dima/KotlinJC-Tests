package com.example.kotlinjc_tests.viewModels

import androidx.lifecycle.ViewModel
import com.example.kotlinjc_tests.models.DataObject
import com.example.kotlinjc_tests.services.NetworkService
import com.example.kotlinjc_tests.utils.ViewState

class DataListViewModel(val service: NetworkService) : ViewModel()  {

    var state = ViewState.LOADING
    var errorMsg: String? = null
    var data: List<DataObject>? = null

    suspend fun loadData() {
        try {
            data = service.fetchData()
            state = ViewState.READY
        } catch (e: Exception) {
            errorMsg = e.message
            state = ViewState.ERROR
        }
    }
}