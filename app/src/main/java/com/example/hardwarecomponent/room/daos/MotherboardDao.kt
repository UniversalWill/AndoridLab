package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.Motherboard

@Dao
interface MotherboardDao {

    @Insert
    fun insert(motherboard: Motherboard)

    @Update
    fun update(motherboard: Motherboard)

    @Query("SELECT * FROM MOTHERBOARD WHERE id = :motherboardId")
    fun getMotherboardById(motherboardId: Int): Motherboard?

    @Query("SELECT * FROM MOTHERBOARD")
    fun getAllMotherboards(): List<Motherboard>

    @Query("DELETE FROM MOTHERBOARD WHERE id = :motherboardId")
    fun deleteMotherboard(motherboardId: Int)
}