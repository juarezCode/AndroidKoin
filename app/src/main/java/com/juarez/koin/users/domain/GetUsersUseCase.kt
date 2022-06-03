package com.juarez.koin.users.domain

import com.juarez.koin.users.data.MainRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val repository: MainRepository) {
    
    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}