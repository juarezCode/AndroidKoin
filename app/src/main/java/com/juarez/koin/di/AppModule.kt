package com.juarez.koin.di

import com.juarez.koin.users.data.MainRepository
import com.juarez.koin.users.data.MainRepositoryImp
import com.juarez.koin.users.domain.GetUsersUseCase
import com.juarez.koin.users.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<MainRepository> {
        MainRepositoryImp(Dispatchers.IO)
    }

    single {
        GetUsersUseCase(get())
    }

    viewModel {
        MainViewModel(get())
    }
}