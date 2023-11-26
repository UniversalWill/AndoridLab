package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.GPU

@Dao
interface GPUDao {

    @Insert
    fun insert(gpu: GPU)

    @Update
    fun update(gpu: GPU)

    @Query("SELECT * FROM GPU WHERE id = :gpuId")
    fun getGPUById(gpuId: Int): GPU?

    @Query("SELECT * FROM GPU")
    fun getAllGPUs(): List<GPU>

    @Query("DELETE FROM GPU WHERE id = :gpuId")
    fun deleteGPU(gpuId: Int)
}