package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.Cases

@Dao
interface CasesDao {
    @Insert
    fun insert(cases: Cases)

    @Update
    fun update(cases: Cases)

    @Query("SELECT * FROM CASES WHERE id = :casesId")
    fun getCasesById(casesId: Int): Cases?

    @Query("SELECT * FROM CASES")
    fun getAllCases(): List<Cases>

    @Query("DELETE FROM CASES WHERE id = :casesId")
    fun deleteCases(casesId: Int)
}