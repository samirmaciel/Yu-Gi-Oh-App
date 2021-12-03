package com.samirmaciel.yugiohapp.shared.di

import com.samirmaciel.yugiohapp.modules.home.MainViewModel
import com.samirmaciel.yugiohapp.shared.data.dataExternal.data_source.APIDataStore
import com.samirmaciel.yugiohapp.shared.data.dataExternal.RepositoryAPI
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    factory {
        APIDataStore.getInstance().create(RepositoryAPI::class.java)
    }
    viewModel{
        MainViewModel(
            repository = get()
        )
    }
}