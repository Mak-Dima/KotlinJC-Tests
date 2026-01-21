package com.example.kotlinjc_tests.services

import com.example.kotlinjc_tests.models.DataObject
import kotlinx.serialization.json.Json


interface NetworkService {
    suspend fun fetchData(): List<DataObject>
}

class MockHttpService(
    var data: String? = null,
    var throwError: Boolean = false
) : NetworkService {

    override suspend fun fetchData(): List<DataObject> {
        if (throwError) {
            throw Exception("Error Message")
        }

        val returnData: List<DataObject>

        if (data != null) {
            returnData = Json.decodeFromString<MutableList<DataObject>>(data!!)
        } else {
            returnData = listOf()
        }

        return returnData
    }
}