package com.example.baseproject.ui

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseproject.data.model.Location
import com.example.baseproject.data.repositories.LocationRepository
import com.example.baseproject.utils.Coroutines
import kotlinx.coroutines.*

class DataViewModel(private val repository: LocationRepository) : ViewModel() {
    val locationList = MutableLiveData<List<Location>>()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    private var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    fun getLocations() {
        CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = repository.getLocations()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    locationList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}