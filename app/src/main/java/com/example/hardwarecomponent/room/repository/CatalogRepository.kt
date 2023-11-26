package com.example.hardwarecomponent.room.repository

import androidx.lifecycle.LiveData
import com.example.hardwarecomponent.room.daos.CatalogDao
import com.example.hardwarecomponent.room.entities.Catalog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatalogRepository(private val catalogDao: CatalogDao) {
    val allProducts: LiveData<List<Catalog>> = catalogDao.getAllProducts()

    suspend fun insertProduct(product: Catalog) {
        withContext(Dispatchers.IO) {
            catalogDao.insert(product)
        }
    }

    suspend fun updateProduct(product: Catalog) {
        withContext(Dispatchers.IO) {
            catalogDao.update(product)
        }
    }

    suspend fun deleteProduct(productId: Int) {
        withContext(Dispatchers.IO) {
            catalogDao.deleteProduct(productId)
        }
    }
}