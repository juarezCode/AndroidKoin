package com.juarez.koin.users.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juarez.koin.users.domain.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private var _usersState = MutableStateFlow<UsersState>(UsersState.Empty)
    val usersState = _usersState.asStateFlow()

    fun getUsers() {
        _usersState.value = UsersState.Loading
        getUsersUseCase().onEach {
            _usersState.value = UsersState.Success(it)
        }.launchIn(viewModelScope)
    }
}