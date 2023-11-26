package com.example.hardwarecomponent.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hardwarecomponent.room.entities.Termopasta

@Dao
interface TermopastaDao {

    @Insert
    fun insert(termopasta: Termopasta)

    @Update
    fun update(termopasta: Termopasta)

    @Query("SELECT * FROM TERMOPASTA WHERE id = :termopastaId")
    fun getTermopastaById(termopastaId: Int): Termopasta?

    @Query("SELECT * FROM TERMOPASTA")
    fun getAllTermopastas(): List<Termopasta>

    @Query("DELETE FROM TERMOPASTA WHERE id = :termopastaId")
    fun deleteTermopasta(termopastaId: Int)
}