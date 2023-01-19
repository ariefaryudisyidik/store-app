package com.ariefaryudisyidik.store.domain.usecase

import com.ariefaryudisyidik.store.data.local.entity.Store
import com.ariefaryudisyidik.store.domain.repository.StoreRepository
import com.ariefaryudisyidik.store.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetStoreListUseCase @Inject constructor(
    private val storeRepository: StoreRepository
) {
    operator fun invoke(): Flow<Resource<List<Store>>> = flow {
        try {
            emit(Resource.Loading())
            val localData: Flow<Resource<List<Store>>> =
                storeRepository.getAllStore().map { Resource.Success(it) }
            emitAll(localData)
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }
}