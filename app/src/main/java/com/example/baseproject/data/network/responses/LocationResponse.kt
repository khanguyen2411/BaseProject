package com.example.baseproject.data.network.responses

import com.example.baseproject.data.model.Location

data class LocationResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val locations: List<Location>?
)
