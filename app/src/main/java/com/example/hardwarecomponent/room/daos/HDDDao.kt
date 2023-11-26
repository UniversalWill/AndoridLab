package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.HDD

@Dao
interface HDDDao {

    @Insert
    fun insert(hdd: HDD)

    @Update
    fun update(hdd: HDD)

    @Query("SELECT * FROM HDD WHERE id = :hddId")
    fun getHDDById(hddId: Int): HDD?

    @Query("SELECT * FROM HDD")
    fun getAllHDDs(): List<HDD>

    @Query("DELETE FROM HDD WHERE id = :hddId")
    fun deleteHDD(hddId: Int)
}