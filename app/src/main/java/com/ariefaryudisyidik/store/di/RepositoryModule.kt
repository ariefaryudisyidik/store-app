package com.ariefaryudisyidik.store.di

import com.ariefaryudisyidik.store.data.local.database.StoreDao
import com.ariefaryudisyidik.store.data.remote.api.ApiService
import com.ariefaryudisyidik.store.data.repository.AuthRepositoryImpl
import com.ariefaryudisyidik.store.data.repository.StoreRepositoryImpl
import com.ariefaryudisyidik.store.domain.repository.AuthRepository
import com.ariefaryudisyidik.store.domain.repository.StoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(api: ApiService): AuthRepository {
        return AuthRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideStoreRepository(dao: StoreDao): StoreRepository {
        return StoreRepositoryImpl(dao)
    }
}