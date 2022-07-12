package com.abdykadyr.mytimer.di

import android.content.Context
import com.abdykadyr.mytimer.data.AppDatabase
import com.abdykadyr.mytimer.data.TimerDao
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class DataModule @Inject constructor(private val context: Context) {

    @Provides
    fun provideTimerDao() : TimerDao {
        return AppDatabase.getInstance(context).timerDao()
    }

}