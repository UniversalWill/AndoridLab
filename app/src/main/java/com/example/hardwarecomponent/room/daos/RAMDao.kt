package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.RAM

@Dao
interface RAMDao {

    @Insert
    fun insert(ram: RAM)

    @Update
    fun update(ram: RAM)

    @Query("SELECT * FROM RAM WHERE id = :ramId")
    fun getRAMById(ramId: Int): RAM?

    @Query("SELECT * FROM RAM")
    fun getAllRAMs(): List<RAM>

    @Query("DELETE FROM RAM WHERE id = :ramId")
    fun deleteRAM(ramId: Int)
}