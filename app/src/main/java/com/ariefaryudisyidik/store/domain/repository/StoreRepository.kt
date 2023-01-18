package com.ariefaryudisyidik.store.domain.repository

import com.ariefaryudisyidik.store.data.local.entity.Store
import kotlinx.coroutines.flow.Flow

interface StoreRepository {
    fun getAllStore(): Flow<List<Store>>
    suspend fun insertStore(stores: List<Store>)
    suspend fun deleteAll()
}