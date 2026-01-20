package com.example.kotlinjc_tests.services

import com.example.kotlinjc_tests.DataObject

interface NetworkService {
    suspend fun fetchData(): MutableList<DataObject>
}