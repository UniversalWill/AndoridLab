package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.SSD

@Dao
interface SSDDao {

    @Insert
    fun insert(sdd: SSD)

    @Update
    fun update(sdd: SSD)

    @Query("SELECT * FROM SDD WHERE id = :sddId")
    fun getSDDById(sddId: Int): SSD?

    @Query("SELECT * FROM SDD")
    fun getAllSDDs(): List<SSD>

    @Query("DELETE FROM SDD WHERE id = :sddId")
    fun deleteSDD(sddId: Int)
}