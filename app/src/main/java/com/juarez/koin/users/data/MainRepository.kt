package com.juarez.koin.users.data

import com.juarez.koin.users.domain.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

interface MainRepository {
    fun getUsers(): Flow<List<User>>
}

class MainRepositoryImp(private val defaultDispatcher: CoroutineDispatcher) : MainRepository {

    override fun getUsers(): Flow<List<User>> = flow {
        delay(2000)
        val users = getUsersFromNetwork()
        emit(users)
    }

    private suspend fun getUsersFromNetwork(): List<User> = withContext(defaultDispatcher) {
        listOf(User(1), User(2))
    }
}