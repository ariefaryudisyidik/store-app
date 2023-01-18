package com.ariefaryudisyidik.store.domain.usecase

import com.ariefaryudisyidik.store.data.local.entity.Store
import com.ariefaryudisyidik.store.domain.repository.AuthRepository
import com.ariefaryudisyidik.store.domain.repository.StoreRepository
import com.ariefaryudisyidik.store.utils.Resource
import com.ariefaryudisyidik.store.utils.getMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val storeRepository: StoreRepository
) {
    operator fun invoke(username: String, password: String): Flow<Resource<List<Store>>> = flow {
        try {
            emit(Resource.Loading())
            val data = authRepository.login(username, password)
            if (data.stores != null) {
                storeRepository.deleteAll()
                storeRepository.insertStore(data.stores)
                val localData: Flow<Resource<List<Store>>> =
                    storeRepository.getAllStore().map { Resource.Success(it) }
                emitAll(localData)
            }
            emit(Resource.Success(data.stores))
        } catch (e: HttpException) {
            emit(Resource.Error(getMessage(e)))
        } catch (e: IOException) {
            emit(Resource.Error("No Internet Connection"))
        }
    }
}