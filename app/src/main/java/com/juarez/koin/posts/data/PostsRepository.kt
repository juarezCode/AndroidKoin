package com.juarez.koin.posts.data

import com.juarez.koin.api.PostsService
import com.juarez.koin.posts.domain.PostResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

interface PostsRepository {
    fun getPosts(): Flow<List<PostResponse>>
}

class PostsRepositoryImp(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PostsRepository {

    val client = PostsService.create()

    override fun getPosts(): Flow<List<PostResponse>> = flow {

        val posts = withContext(defaultDispatcher) { client.getPosts() }
        emit(posts)
    }
}