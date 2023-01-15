package com.ariefaryudisyidik.store.data.remote.response

import com.ariefaryudisyidik.store.domain.model.Store

data class LoginResponse(
    val message: String?,
    val status: String?,
    val stores: List<Store>?
)
