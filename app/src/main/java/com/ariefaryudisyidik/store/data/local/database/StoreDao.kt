package com.ariefaryudisyidik.store.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ariefaryudisyidik.store.data.local.entity.Store
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStore(store: List<Store>)

    @Query("SELECT * FROM store")
    fun getAllStore(): Flow<List<Store>>

    @Query("DELETE FROM store")
    suspend fun deleteAll()
}