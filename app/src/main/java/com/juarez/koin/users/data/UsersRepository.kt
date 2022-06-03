package com.juarez.koin.users.data

import com.juarez.koin.api.PostsService
import com.juarez.koin.users.domain.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

interface UsersRepository {
    fun getUsers(): Flow<List<User>>
}

class UsersRepositoryImp(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : UsersRepository {

    val client = PostsService.create()

    override fun getUsers(): Flow<List<User>> = flow {
        delay(2000)
        val users = getUsersFromNetwork()
        emit(users)
    }


    private suspend fun getUsersFromNetwork(): List<User> = withContext(defaultDispatcher) {
        listOf(User(1), User(2))
    }
}