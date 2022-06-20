package com.abdykadyr.mytimer.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun addTimerUseCase(myTimer: MyTimer)
    fun deleteTimerUseCase(myTimer: MyTimer)
    fun editTimerUseCase(myTimer: MyTimer)
    fun getAllTimersUseCase() : LiveData<List<MyTimer>>
    fun getTimerUseCase(timerId: Int)  : MyTimer
}