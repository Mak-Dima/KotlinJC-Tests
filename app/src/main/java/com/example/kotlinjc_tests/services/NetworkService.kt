package com.example.kotlinjc_tests.services

import com.example.kotlinjc_tests.models.DataObject
import kotlinx.serialization.json.Json


interface NetworkService {
    suspend fun fetchData(): MutableList<DataObject>
}

class MockHttpService(
    var data: String? = null,
    var throwError: Boolean = false
) : NetworkService {

    override suspend fun fetchData(): MutableList<DataObject> {
        if (throwError) {
            throw Exception("Error Message")
        }

        val returnData: MutableList<DataObject>

        if (data != null) {
            returnData = Json.decodeFromString<MutableList<DataObject>>(data!!)
        } else {
            returnData = mutableListOf()
        }

        return returnData
    }
}