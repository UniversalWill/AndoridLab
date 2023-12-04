package com.example.hardwarecomponent.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.hardwarecomponent.room.RoomDb
import com.example.hardwarecomponent.room.entities.CPU
import com.example.hardwarecomponent.room.repository.CpuRepository
import kotlinx.coroutines.launch

class CpuViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CpuRepository
    val allCPU: LiveData<List<CPU>>

    init {
        val cpuDao = RoomDb.getDatabase(application).cpuDao()
        repository = CpuRepository(cpuDao)
        allCPU = repository.allCPU
    }

    fun insertCPU(cpu: CPU) {
        viewModelScope.launch {
            repository.insertProduct(cpu)
        }
    }
}