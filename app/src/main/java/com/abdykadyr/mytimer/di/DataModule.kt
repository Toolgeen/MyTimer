package com.abdykadyr.mytimer.di

import android.content.Context
import com.abdykadyr.mytimer.data.AppDatabase
import com.abdykadyr.mytimer.data.TimerDao
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideTimerDao(context : Context) : TimerDao {
        return AppDatabase.getInstance(context).timerDao()
    }

}