package com.example.observables

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.observables.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLiveData.setOnClickListener {
            viewModel.triggerLiveData()
        }
        binding.btnStateFlow.setOnClickListener {
            viewModel.triggerStateFlow()
        }
        binding.btnFlow.setOnClickListener {
            viewModel.triggerFlow()
        }
        binding.btnSharedFlow.setOnClickListener {
            viewModel.triggerSharedFlow()
        }

        subscribeToObservables()
    }

    private fun subscribeToObservables() {
        viewModel.liveData.observe(this) {
            binding.tvLiveData.text = it
        }

        lifecycleScope.launchWhenStarted {
            viewModel.stateFlow.collectLatest {
                binding.tvStateFlow.text = it
            }
        }
    }
}