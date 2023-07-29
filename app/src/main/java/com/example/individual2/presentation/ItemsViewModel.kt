package com.example.individual2.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.individual2.data.Repository
import com.example.individual2.data.local.ItemDatabase
import com.example.individual2.data.local.ItemEntity
import kotlinx.coroutines.launch

class ItemsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDatabase.getDatabase(application).getItemsDao()
        repository = Repository(dao)
    }

    fun getAllItems(): LiveData<List<ItemEntity>> = repository.getAllItems()

    fun insertItem(name: String, price: Int, quantity: Int) = viewModelScope.launch {
        val item = ItemEntity(name, price, quantity)
        repository.insertItem(item)
    }
}