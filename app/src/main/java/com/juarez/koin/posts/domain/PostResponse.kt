package com.juarez.koin.posts.domain

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(val id: Int, val title: String)