package com.ariefaryudisyidik.store.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ariefaryudisyidik.store.data.local.entity.Store

@Database(
    entities = [Store::class],
    version = 1,
    exportSchema = false
)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun storeDao(): StoreDao
}