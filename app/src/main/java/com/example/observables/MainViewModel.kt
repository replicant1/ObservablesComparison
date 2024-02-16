package com.example.observables

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _liveData = MutableLiveData("Hello World")
    val liveData : LiveData<String> = _liveData

    fun triggerLiveData() {
        println("Trigger live data")
        _liveData.value = "LiveData"
    }

    fun triggerStateFlow() {
        println("Trigger State Flow")
    }

    fun triggerFlow() {
        println("Trigger Flow")
    }

    fun triggerSharedFlow() {
        println("Trigger Shared Flow")
    }
}