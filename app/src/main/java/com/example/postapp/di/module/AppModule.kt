package com.example.postapp.di.module

import android.app.Application
import android.content.Context
import com.example.postapp.di.module.remote.RemoteModule
import com.example.postapp.di.module.repository.RepositoryModule
import com.example.postapp.di.module.room.RoomModule
import com.example.postapp.di.module.viewmodel.ViewModelModule
import com.example.postapp.utils.NetworkState
import com.example.postapp.utils.NetworkStateImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes =
    [AppModule.Binders::class,
        RepositoryModule::class,
        RemoteModule::class,
        ViewModelModule::class,
        RoomModule::class
    ]
)
class AppModule {

    @Module
    interface Binders {
        @Binds
        fun bindNetworkState(networkState: NetworkStateImpl): NetworkState
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext


}