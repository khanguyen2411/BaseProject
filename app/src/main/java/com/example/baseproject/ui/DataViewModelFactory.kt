package com.example.baseproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.baseproject.data.repositories.LocationRepository

@Suppress("UNCHECKED_CAST")
class DataViewModelFactory(
    private val repository: LocationRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataViewModel(repository) as T
    }
}