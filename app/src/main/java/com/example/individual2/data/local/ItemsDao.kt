package com.example.individual2.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

const val defaultStrategy = OnConflictStrategy.IGNORE
@Dao
interface ItemsDao {

    @Insert(onConflict = defaultStrategy)
    suspend fun insertItem(item: ItemEntity)

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun getAllItems(): LiveData<List<ItemEntity>>

    @Delete
    fun deleteItems(items: List<ItemEntity>)
}