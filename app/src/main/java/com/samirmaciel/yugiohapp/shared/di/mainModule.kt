package com.samirmaciel.yugiohapp.shared.di

import com.samirmaciel.yugiohapp.modules.home.MainViewModel
import com.samirmaciel.yugiohapp.modules.myDeck.MyDeckViewModel
import com.samirmaciel.yugiohapp.shared.data.dataExternal.data_source.APIDataStore
import com.samirmaciel.yugiohapp.shared.data.dataExternal.repository.RepositoryAPI
import com.samirmaciel.yugiohapp.shared.data.dataInternal.data_source.DatabaseRoom
import com.samirmaciel.yugiohapp.shared.data.dataInternal.repository.CardRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    single {
        CardRepositoryImpl(DatabaseRoom.getDatabase(androidContext()).cardDao())
    }

    single {
        APIDataStore.getInstance().create(RepositoryAPI::class.java)
    }

    viewModel{
        MainViewModel(
            repositoryExternal = get(),
            repositoryInternal = get()
        )
    }

    viewModel{
        MyDeckViewModel(
            repositoryInternal = get()
        )

    }
}