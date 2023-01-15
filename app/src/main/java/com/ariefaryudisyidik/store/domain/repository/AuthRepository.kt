package com.ariefaryudisyidik.store.domain.repository

import com.ariefaryudisyidik.store.data.remote.response.LoginResponse

interface AuthRepository {
    suspend fun login(username: String, password: String): LoginResponse
}