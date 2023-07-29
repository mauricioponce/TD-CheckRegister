package com.example.individual2.data

import androidx.lifecycle.LiveData
import com.example.individual2.data.local.ItemEntity
import com.example.individual2.data.local.ItemsDao

class Repository(private val itemsDao: ItemsDao) {

    fun getAllItems(): LiveData<List<ItemEntity>> = itemsDao.getAllItems()

    suspend fun insertItem(item: ItemEntity) {
        itemsDao.insertItem(item)
    }
}