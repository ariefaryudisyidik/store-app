package com.ariefaryudisyidik.store.data.repository

import com.ariefaryudisyidik.store.data.remote.api.ApiService
import com.ariefaryudisyidik.store.data.remote.response.LoginResponse
import com.ariefaryudisyidik.store.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: ApiService
) : AuthRepository {

    override suspend fun login(username: String, password: String): LoginResponse {
        return api.login(username, password)
    }
}