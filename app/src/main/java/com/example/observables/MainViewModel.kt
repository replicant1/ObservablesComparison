package com.example.observables

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

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

    fun triggerFlow() {
        println("Trigger Flow")
    }

    fun triggerSharedFlow() {
        println("Trigger Shared Flow")
    }
}