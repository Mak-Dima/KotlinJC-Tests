package com.example.kotlinjc_tests.services

import com.example.kotlinjc_tests.models.DataObject

interface NetworkService {
    suspend fun fetchData(): MutableList<DataObject>
}

class MockHttpService() : NetworkService {
    override suspend fun fetchData(): MutableList<DataObject> {
        val data: MutableList<DataObject> = mutableListOf()


        return data
    }
}