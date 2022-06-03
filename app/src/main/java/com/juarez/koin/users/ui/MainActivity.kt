package com.juarez.koin.users.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.juarez.koin.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getUsers()

        lifecycleScope.launchWhenStarted {
            mainViewModel.usersState.collect {
                when (it) {
                    is UsersState.Error -> {
                        binding.progressBarMain.isVisible = false
                        Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
                        Log.d("User", "exception ${it.exception.localizedMessage}")
                    }
                    is UsersState.Loading -> {
                        binding.progressBarMain.isVisible = true
                        Log.d("User", "loading")
                    }
                    is UsersState.Success -> {
                        binding.progressBarMain.isVisible = false
                        Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()
                        Log.d("User", "success ${it.users}")
                    }
                    else -> Unit
                }
            }
        }
    }
}