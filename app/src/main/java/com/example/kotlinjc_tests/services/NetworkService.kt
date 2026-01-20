package com.example.kotlinjc_tests.services

interface NetworkService {
    suspend fun fetchData(): List<Int>
}