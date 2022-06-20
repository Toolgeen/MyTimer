package com.abdykadyr.mytimer.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdykadyr.mytimer.data.RepositoryImpl
import com.abdykadyr.mytimer.domain.*


class ApplicationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private var _isHoursValid = MutableLiveData(false)
    val isHoursValid: LiveData<Boolean>
    get() = _isHoursValid

    private var _isMinutesValid = MutableLiveData(false)
    val isMinutesValid: LiveData<Boolean>
        get() = _isMinutesValid

    private val addTimerUseCase = AddTimerUseCase(repository)
    private val deleteTimerUseCase = DeleteTimerUseCase(repository)
    private val editTimerUseCase = EditTimerUseCase(repository)
    private val getAllTimersUseCase = GetAllTimersUseCase(repository)
    private val getTimerUseCase = GetTimerUseCase(repository)

    fun getTimers() = getAllTimersUseCase

    fun addTimer(plannedTime: Int, spentTime: Int, isDone: Boolean) {
        addTimerUseCase(
            MyTimer(
                plannedTime = plannedTime,
                spentTime = spentTime,
                isDone = isDone
            )
        )
    }

    fun deleteTimer(myTimerId: Int) = deleteTimerUseCase.invoke(myTimerId)

    fun getTimer(myTimerId: Int) = getTimerUseCase.invoke(myTimerId)
}