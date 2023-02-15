package com.clint.networkmanager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.clint.networkmanager.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(binding.root)
        setClickListeners()
        setObservers()
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.errorHandling.collect {
                        Log.e("exception", it.toString())
                    }
                }
                launch {
                    viewModel.customUi.collect {
                        Log.e("customUi", Gson().toJson(it))
                    }
                }
                launch {
                    viewModel.customLogo.collect {
                        Log.e("custom_logo", it.toString())
                    }
                }
            }

        }
    }

    private fun setClickListeners() {
        binding.txtViewFetchData.setOnClickListener {
            viewModel.fetchCustomUi(url = "dbe3ae4916485294979f")
            viewModel.fetchCustomLogo(url = "dbe3ae4916485294979f")
        }
    }
}