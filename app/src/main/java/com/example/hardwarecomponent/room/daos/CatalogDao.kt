package com.example.hardwarecomponent.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.Catalog

@Dao
interface CatalogDao {

    @Insert
    fun insert(product: Catalog)

    @Update
    fun update(product: Catalog)

    @Query("SELECT * FROM catalog_product WHERE id = :productId")
    fun getProductById(productId: Int): Catalog?

    @Query("SELECT * FROM catalog_product")
    fun getAllProducts(): LiveData<List<Catalog>>

    @Query("DELETE FROM catalog_product WHERE id = :productId")
    fun deleteProduct(productId: Int)
}