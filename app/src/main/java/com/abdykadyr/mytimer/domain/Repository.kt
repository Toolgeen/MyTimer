package com.abdykadyr.mytimer.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun addTimerUseCase(myTimer: MyTimer)
    fun deleteTimerUseCase(myTimerId: Int)
    fun editTimerUseCase(myTimer: MyTimer)
    fun getAllTimersUseCase() : LiveData<List<MyTimer>>
    fun getTimerUseCase(myTimerId: Int)  : MyTimer
}