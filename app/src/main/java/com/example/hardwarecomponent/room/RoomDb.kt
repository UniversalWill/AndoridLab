package com.example.hardwarecomponent.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hardwarecomponent.room.daos.CPUDao
import com.example.hardwarecomponent.room.daos.CasesDao
import com.example.hardwarecomponent.room.daos.CatalogDao
import com.example.hardwarecomponent.room.daos.CoolerDao
import com.example.hardwarecomponent.room.daos.GPUDao
import com.example.hardwarecomponent.room.daos.HDDDao
import com.example.hardwarecomponent.room.daos.MotherboardDao
import com.example.hardwarecomponent.room.daos.OpticalDriveDao
import com.example.hardwarecomponent.room.daos.PSUDao
import com.example.hardwarecomponent.room.daos.RAMDao
import com.example.hardwarecomponent.room.daos.SSDDao
import com.example.hardwarecomponent.room.daos.TermopastaDao
import com.example.hardwarecomponent.room.daos.WaterCoolerDao
import com.example.hardwarecomponent.room.entities.CPU
import com.example.hardwarecomponent.room.entities.Cases
import com.example.hardwarecomponent.room.entities.Catalog
import com.example.hardwarecomponent.room.entities.Cooler
import com.example.hardwarecomponent.room.entities.GPU
import com.example.hardwarecomponent.room.entities.HDD
import com.example.hardwarecomponent.room.entities.Motherboard
import com.example.hardwarecomponent.room.entities.OpticalDrive
import com.example.hardwarecomponent.room.entities.PSU
import com.example.hardwarecomponent.room.entities.RAM
import com.example.hardwarecomponent.room.entities.SSD
import com.example.hardwarecomponent.room.entities.Termopasta
import com.example.hardwarecomponent.room.entities.WaterCooler


@Database(
    entities = [Catalog::class, Cases::class, Cooler::class, CPU::class, GPU::class, HDD::class,
        Motherboard::class, OpticalDrive::class, PSU::class, RAM::class,
        SSD::class, Termopasta::class, WaterCooler::class],
    version = 1,
    exportSchema = false
)
abstract class RoomDb : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
    abstract fun casesDao(): CasesDao
    abstract fun coolerDao(): CoolerDao
    abstract fun cpuDao(): CPUDao
    abstract fun gpuDao(): GPUDao
    abstract fun hddDao(): HDDDao
    abstract fun motherboardDao(): MotherboardDao
    abstract fun opticalDriveDao(): OpticalDriveDao
    abstract fun psuDao(): PSUDao
    abstract fun ramDao(): RAMDao
    abstract fun sddDao(): SSDDao
    abstract fun termopastaDao(): TermopastaDao
    abstract fun waterCoolerDao(): WaterCoolerDao

    companion object {
        // Переменная для хранения экземпляра базы данных
        @Volatile
        private var INSTANCE: RoomDb? = null

        // Метод для получения экземпляра базы данных
        fun getDatabase(context: Context): RoomDb {
            return INSTANCE ?: synchronized(this) {
                // Если экземпляр базы данных еще не создан, создаем его с использованием createFromAsset
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDb::class.java,
                    "catalog.db"
                )
                    .createFromAsset("catalog.db")
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}