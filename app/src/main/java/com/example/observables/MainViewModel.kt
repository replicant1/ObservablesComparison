package com.example.observables

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _liveData = MutableLiveData<String>("Hello World")
    val liveData : LiveData<String> = _liveData

    private val _stateFlow = MutableStateFlow("Hello World")
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun triggerLiveData() {
        println("Trigger live data")
        _liveData.value = "LiveData"
    }

    fun triggerStateFlow() {
        println("Trigger State Flow")
        _stateFlow.value = "StateFlow"
    }

    fun triggerFlow() : Flow<String> {
        // There is no "value" property because a Flow doesn't hold
        // a value, it *does* something
        return flow {
            repeat(5) {
                emit("Item $it")
                delay(1000L)
            }
        }
    }

    fun triggerSharedFlow() {
        println("Trigger Shared Flow")
        viewModelScope.launch {
            _sharedFlow.emit("SharedFlow")
        }
    }
}