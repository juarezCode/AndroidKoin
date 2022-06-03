package com.juarez.koin.users.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.juarez.koin.databinding.ActivityMainBinding
import com.juarez.koin.posts.ui.PostsState
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
        mainViewModel.getPosts()

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
                        Toast.makeText(this@MainActivity, "success users", Toast.LENGTH_SHORT)
                            .show()
                        Log.d("User", "success ${it.users}")
                    }
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            mainViewModel.postsState.collect {
                when (it) {
                    is PostsState.Error -> {
                        binding.progressBarMain.isVisible = false
                        Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show()
                        Log.d("Post", "exception ${it.exception.localizedMessage}")
                    }
                    is PostsState.Loading -> {
                        binding.progressBarMain.isVisible = true
                        Log.d("Post", "loading")
                    }
                    is PostsState.Success -> {
                        binding.progressBarMain.isVisible = false
                        Toast.makeText(this@MainActivity, "success posts", Toast.LENGTH_SHORT)
                            .show()
                        Log.d("Post", "success ${it.users}")
                    }
                    else -> Unit
                }
            }
        }
    }
}