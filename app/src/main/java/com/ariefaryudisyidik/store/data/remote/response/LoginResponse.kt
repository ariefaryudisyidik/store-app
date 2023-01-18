package com.ariefaryudisyidik.store.data.remote.response

import com.ariefaryudisyidik.store.data.local.entity.Store

data class LoginResponse(
    val message: String?,
    val status: String?,
    val stores: List<Store>?
)
