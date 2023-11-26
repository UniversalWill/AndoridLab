package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.PSU

@Dao
interface PSUDao {

    @Insert
    fun insert(psu: PSU)

    @Update
    fun update(psu: PSU)

    @Query("SELECT * FROM PSU WHERE id = :psuId")
    fun getPSUById(psuId: Int): PSU?

    @Query("SELECT * FROM PSU")
    fun getAllPSUs(): List<PSU>

    @Query("DELETE FROM PSU WHERE id = :psuId")
    fun deletePSU(psuId: Int)
}