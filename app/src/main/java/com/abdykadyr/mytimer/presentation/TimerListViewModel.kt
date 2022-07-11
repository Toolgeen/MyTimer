package com.abdykadyr.mytimer.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.abdykadyr.mytimer.data.RepositoryImpl
import com.abdykadyr.mytimer.domain.*

class TimerListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val addTimerUseCase = AddTimerUseCase(repository)
    private val deleteTimerUseCase = DeleteTimerUseCase(repository)
    private val editTimerUseCase = EditTimerUseCase(repository)
    private val getAllTimersUseCase = GetAllTimersUseCase(repository)
    private val getTimerUseCase = GetTimerUseCase(repository)
    private val pauseTimerUseCase = PauseTimerUseCase(repository)
    private val startTimerUseCase = StartTimerUseCase(repository)

    val timerList = getAllTimersUseCase.invoke()

    fun addTimer(hours: Int, minutes: Int) : Boolean {
        return if (validateInput(hours,minutes)) {
            addTimerUseCase(
                MyTimer(
                    plannedTime = (hours * 3600) + (minutes * 60)
                )
            )
            true
        } else false
    }

    fun editTimer(myTimer: MyTimer, spentTime: Int, isDone: Boolean, whenStartedTime: Int) {
        val newTimer = myTimer.copy(
            spentTime = spentTime,
            isDone = isDone,
            whenStartedTime = whenStartedTime
        )
        editTimerUseCase(newTimer)
    }

    fun deleteTimer(myTimerId: Int) = deleteTimerUseCase.invoke(myTimerId)

    fun getTimer(myTimerId: Int) = getTimerUseCase.invoke(myTimerId)

    private fun validateInput(hours: Int, minutes: Int) : Boolean {
        return (hours>= 0) && ((minutes > 0) || (hours != 0))
    }

    fun startTimer(myTimerId: Int) {
        startTimerUseCase.invoke(getTimer(myTimerId))
    }

    fun pauseTimer(myTimerId: Int) {
        pauseTimerUseCase.invoke(getTimer(myTimerId))
    }

}