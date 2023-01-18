package com.ariefaryudisyidik.store.data.repository

import com.ariefaryudisyidik.store.data.local.database.StoreDao
import com.ariefaryudisyidik.store.data.local.entity.Store
import com.ariefaryudisyidik.store.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val dao: StoreDao
) : StoreRepository {

    override fun getAllStore(): Flow<List<Store>> {
        return dao.getAllStore()
    }

    override suspend fun insertStore(stores: List<Store>) {
        return dao.insertStore(stores)
    }

    override suspend fun deleteAll() {
        return dao.deleteAll()
    }
}