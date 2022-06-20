package com.abdykadyr.mytimer.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abdykadyr.mytimer.data.RepositoryImpl
import com.abdykadyr.mytimer.domain.*


class ApplicationViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val addTimerUseCase = AddTimerUseCase(repository)
    private val deleteTimerUseCase = DeleteTimerUseCase(repository)
    private val editTimerUseCase = EditTimerUseCase(repository)
    private val getAllTimersUseCase = GetAllTimersUseCase(repository)
    private val getTimerUseCase = GetTimerUseCase(repository)



}