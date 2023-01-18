package com.ariefaryudisyidik.store.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "store")
data class Store(
    @PrimaryKey
    val store_id: String,
    val store_code: String,
    val store_name: String,
    val account_id: String,
    val account_name: String,
    val address: String,
    val area_id: String,
    val area_name: String,
    val channel_id: String,
    val channel_name: String,
    val dc_id: String,
    val dc_name: String,
    val latitude: String,
    val longitude: String,
    val region_id: String,
    val region_name: String,
    val subchannel_id: String,
    val subchannel_name: String
) : Parcelable