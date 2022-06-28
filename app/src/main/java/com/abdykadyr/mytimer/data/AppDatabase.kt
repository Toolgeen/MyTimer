package com.abdykadyr.mytimer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyTimerDbModel::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun timerDao() : TimerDao

    companion object {

        private var db : AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context) : AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .build()
                db = instance
                return instance
            }
        }

    }

}