package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.CPU

@Dao
interface CPUDao {

    @Insert
    fun insert(cpu: CPU)

    @Update
    fun update(cpu: CPU)

    @Query("SELECT * FROM CPU WHERE id = :cpuId")
     fun getCPUById(cpuId: Int): CPU?

    @Query("SELECT * FROM CPU")
     fun getAllCPUs(): List<CPU>

    @Query("DELETE FROM CPU WHERE id = :cpuId")
     fun deleteCPU(cpuId: Int)
}