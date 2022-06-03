package com.juarez.koin.users.ui

import com.juarez.koin.users.domain.User

sealed class UsersState {
    object Loading : UsersState()
    object Empty : UsersState()
    data class Error(val exception: Throwable) : UsersState()
    data class Success(val users: List<User>) : UsersState()
}
