package com.juarez.koin.users.domain

import com.juarez.koin.users.data.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val repository: UsersRepository) {

    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}