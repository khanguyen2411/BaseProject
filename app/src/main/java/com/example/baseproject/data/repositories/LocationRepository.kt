package com.example.baseproject.data.repositories

import com.example.baseproject.data.network.Api
import com.example.baseproject.utils.Constants


class LocationRepository(
    private val api: Api
) {
    suspend fun getLocations() = api.getLocations(Constants.SEARCH_PARAMS)
}