package com.example.kotlinjc_tests.services

import com.example.kotlinjc_tests.models.DataObject
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
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

        return data?.let { Json.decodeFromString(it) } ?: emptyList()
    }
}

class HttpService: NetworkService {

    override suspend fun fetchData(): List<DataObject> {
        var data: List<DataObject> = listOf()
        val client = HttpClient(CIO)

        try {
            val response = client.get("http://10.0.2.2:8080/default/read")
            if (response.status.value == 200) {
                val body = response.bodyAsText()
                data = Json.decodeFromString(body)
            } else {
                throw Exception("Invalid status code")
            }
        } catch (e: Exception) {
            throw e
        }

        return data
    }
}