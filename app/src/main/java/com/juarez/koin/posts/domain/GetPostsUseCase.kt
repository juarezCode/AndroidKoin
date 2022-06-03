package com.juarez.koin.posts.domain

import com.juarez.koin.posts.data.PostsRepository
import kotlinx.coroutines.flow.Flow

class GetPostsUseCase(private val repository: PostsRepository) {

    operator fun invoke(): Flow<List<PostResponse>> {
        return repository.getPosts()
    }
}