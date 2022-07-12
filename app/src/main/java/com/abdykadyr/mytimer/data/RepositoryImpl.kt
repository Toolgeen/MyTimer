package com.abdykadyr.mytimer.data

import androidx.lifecycle.LiveData
import com.abdykadyr.mytimer.domain.MyTimer
import com.abdykadyr.mytimer.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val timerDao: TimerDao,
    private val mapper: Mapper
) : Repository {

    override fun addTimerUseCase(myTimer: MyTimer) {
        timerDao.addTimer(mapper.myTimerEntityToDbModel(myTimer))
    }

    override fun deleteTimerUseCase(myTimerId: Int) {
        timerDao.deleteTimer(timerDao.getTimer(myTimerId))
    }

    override fun editTimerUseCase(myTimer: MyTimer) {
        timerDao.deleteTimer(timerDao.getTimer(myTimer.id))
        timerDao.addTimer(mapper.myTimerEntityToDbModel(myTimer))
    }

    override fun getAllTimersUseCase(): LiveData<List<MyTimer>> {
        return mapper.myTimerDbModelListToEntityList(timerDao.getAllTimers())
    }

    override fun getTimerUseCase(myTimerId: Int): MyTimer {
        return mapper.myTimerDbModelToEntity(timerDao.getTimer(myTimerId))
    }

    override fun startTimerUseCase(myTimer: MyTimer) {
        val newTimer = myTimer.copy(
            whenStartedTime = getCurrentTimeInSeconds()
        )
        editTimerUseCase(newTimer)
    }

    override fun pauseTimerUseCase(myTimer: MyTimer) {
        if (myTimer.whenStartedTime != MyTimer.TIMER_ON_PAUSE) {
            val newTimer = myTimer.copy(
                spentTime = getCurrentTimeInSeconds() - myTimer.whenStartedTime,
                whenStartedTime = MyTimer.TIMER_ON_PAUSE,
            )
            editTimerUseCase(newTimer)
        }
    }

    private fun getCurrentTimeInSeconds() = (System.currentTimeMillis() / 1000).toInt()
}