package com.example.hardwarecomponent.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hardwarecomponent.room.RoomDb
import com.example.hardwarecomponent.room.entities.Catalog
import com.example.hardwarecomponent.room.repository.CatalogRepository
import kotlinx.coroutines.launch

class CatalogViewModel(application: Application) : AndroidViewModel(application){
    private val repository: CatalogRepository
    val allProducts: LiveData<List<Catalog>>

    init {
        val catalogDao = RoomDb.getDatabase(application).catalogDao()
        repository = CatalogRepository(catalogDao)
        allProducts = repository.allProducts
    }

    fun insertProduct(product: Catalog) {
        viewModelScope.launch {
            repository.insertProduct(product)
        }
    }
}