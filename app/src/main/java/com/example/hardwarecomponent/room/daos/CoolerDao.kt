package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.Cooler

@Dao
interface CoolerDao {

    @Insert
    fun insert(cooler: Cooler)

    @Update
    fun update(cooler: Cooler)

    @Query("SELECT * FROM COOLER WHERE id = :coolerId")
     fun getCoolerById(coolerId: Int): Cooler?

    @Query("SELECT * FROM COOLER")
    fun getAllCoolers(): List<Cooler>

    @Query("DELETE FROM COOLER WHERE id = :coolerId")
     fun deleteCooler(coolerId: Int)
}