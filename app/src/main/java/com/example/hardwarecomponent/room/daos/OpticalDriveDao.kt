package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.OpticalDrive

@Dao
interface OpticalDriveDao {

    @Insert
    fun insert(opticalDrive: OpticalDrive)

    @Update
    fun update(opticalDrive: OpticalDrive)

    @Query("SELECT * FROM OPTICAL_DRIVE WHERE id = :opticalDriveId")
    fun getOpticalDriveById(opticalDriveId: Int): OpticalDrive?

    @Query("SELECT * FROM OPTICAL_DRIVE")
    fun getAllOpticalDrives(): List<OpticalDrive>

    @Query("DELETE FROM OPTICAL_DRIVE WHERE id = :opticalDriveId")
    fun deleteOpticalDrive(opticalDriveId: Int)
}