package com.abdykadyr.mytimer.presentation

import androidx.lifecycle.ViewModel
import com.abdykadyr.mytimer.domain.*
import javax.inject.Inject

class TimerListViewModel @Inject constructor(
    private val addTimerUseCase: AddTimerUseCase,
    private val deleteTimerUseCase: DeleteTimerUseCase,
    private val editTimerUseCase: EditTimerUseCase,
    private val getAllTimersUseCase: GetAllTimersUseCase,
    private val getTimerUseCase: GetTimerUseCase,
    private val pauseTimerUseCase: PauseTimerUseCase,
    private val startTimerUseCase: StartTimerUseCase,
) : ViewModel(

) {
    val timerList = getAllTimersUseCase.invoke()

    fun addTimer(hours: Int, minutes: Int): Boolean {
        return if (validateInput(hours, minutes)) {
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

    private fun validateInput(hours: Int, minutes: Int): Boolean {
        return (hours >= 0) && ((minutes > 0) || (hours != 0))
    }

    fun startTimer(myTimerId: Int) {
        startTimerUseCase.invoke(getTimer(myTimerId))
    }

    fun pauseTimer(myTimerId: Int) {
        pauseTimerUseCase.invoke(getTimer(myTimerId))
    }

}