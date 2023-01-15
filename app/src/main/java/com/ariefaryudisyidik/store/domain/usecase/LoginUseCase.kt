package com.ariefaryudisyidik.store.domain.usecase

import com.ariefaryudisyidik.store.data.remote.response.LoginResponse
import com.ariefaryudisyidik.store.domain.repository.AuthRepository
import com.ariefaryudisyidik.store.utils.Resource
import com.ariefaryudisyidik.store.utils.getMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    operator fun invoke(username: String, password: String): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            val data = authRepository.login(username, password)
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(getMessage(e)))
        } catch (e: IOException) {
            emit(Resource.Error("No Internet Connection"))
        }
    }
}