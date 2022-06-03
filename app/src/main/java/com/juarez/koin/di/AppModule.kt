package com.juarez.koin.di

import com.juarez.koin.posts.data.PostsRepository
import com.juarez.koin.posts.data.PostsRepositoryImp
import com.juarez.koin.posts.domain.GetPostsUseCase
import com.juarez.koin.users.data.UsersRepository
import com.juarez.koin.users.data.UsersRepositoryImp
import com.juarez.koin.users.domain.GetUsersUseCase
import com.juarez.koin.users.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<UsersRepository> {
        UsersRepositoryImp(Dispatchers.IO)
    }

    single<PostsRepository> {
        PostsRepositoryImp(Dispatchers.IO)
    }

    single {
        GetUsersUseCase(get())
    }

    single {
        GetPostsUseCase(get())
    }

    viewModel {
        MainViewModel(get(), get())
    }
}