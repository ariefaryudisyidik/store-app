package com.ariefaryudisyidik.store.di

import android.content.Context
import androidx.room.Room
import com.ariefaryudisyidik.store.data.local.database.StoreDatabase
import com.ariefaryudisyidik.store.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        StoreDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideDao(database: StoreDatabase) = database.storeDao()
}