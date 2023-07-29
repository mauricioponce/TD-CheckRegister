package com.example.individual2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class ItemEntity(val name: String, val price: Int, val quantity: Int) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}