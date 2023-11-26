package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.WaterCooler

@Dao
interface WaterCoolerDao {

    @Insert
    fun insert(waterCooler: WaterCooler)

    @Update
    fun update(waterCooler: WaterCooler)

    @Query("SELECT * FROM WATER_COOLER WHERE id = :waterCoolerId")
    fun getWaterCoolerById(waterCoolerId: Int): WaterCooler?

    @Query("SELECT * FROM WATER_COOLER")
    fun getAllWaterCoolers(): List<WaterCooler>

    @Query("DELETE FROM WATER_COOLER WHERE id = :waterCoolerId")
    fun deleteWaterCooler(waterCoolerId: Int)
}