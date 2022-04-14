package com.example.baseproject.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object Coroutines {
    fun IO(work: suspend (()->Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }
}