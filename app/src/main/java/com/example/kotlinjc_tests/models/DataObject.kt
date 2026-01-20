package com.example.kotlinjc_tests.models

import kotlinx.serialization.Serializable

@Serializable
data class DataObject(
    var id: String,
    var name: String
)
