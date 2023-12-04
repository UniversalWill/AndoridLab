package com.example.hardwarecomponent.room.repository

import androidx.lifecycle.LiveData
import com.example.hardwarecomponent.room.daos.CPUDao
import com.example.hardwarecomponent.room.entities.CPU
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CpuRepository(private val cpuDao: CPUDao) {
    val allCPU: LiveData<List<CPU>> = cpuDao.getAllCPUs()

    suspend fun insertProduct(cpu: CPU) {
        withContext(Dispatchers.IO) {
            cpuDao.insert(cpu)
        }
    }

    suspend fun updateProduct(cpu: CPU) {
        withContext(Dispatchers.IO) {
            cpuDao.update(cpu)
        }
    }

    suspend fun deleteProduct(cpuId: Int) {
        withContext(Dispatchers.IO) {
            cpuDao.deleteCPU(cpuId)
        }
    }
}