package com.juarez.koin.posts.ui

import com.juarez.koin.posts.domain.PostResponse

sealed class PostsState {
    object Loading : PostsState()
    object Empty : PostsState()
    data class Error(val exception: Throwable) : PostsState()
    data class Success(val users: List<PostResponse>) : PostsState()
}
