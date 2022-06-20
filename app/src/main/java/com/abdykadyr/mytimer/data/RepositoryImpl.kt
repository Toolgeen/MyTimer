package com.abdykadyr.mytimer.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.abdykadyr.mytimer.domain.MyTimer
import com.abdykadyr.mytimer.domain.Repository

class RepositoryImpl(application: Application) : Repository {

    private val timerDao = AppDatabase.getInstance(application).timerDao()
    private val mapper = Mapper()

    override fun addTimerUseCase(myTimer: MyTimer) {
        timerDao.addTimer(mapper.myTimerEntityToDbModel(myTimer))
    }

    override fun deleteTimerUseCase(myTimerId : Int) {
        timerDao.deleteTimer(timerDao.getTimer(myTimerId))
    }

    override fun editTimerUseCase(myTimer: MyTimer) {
        timerDao.deleteTimer(timerDao.getTimer(myTimer.id))
        timerDao.addTimer(mapper.myTimerEntityToDbModel(myTimer))
    }

    override fun getAllTimersUseCase(): LiveData<List<MyTimer>> {
        return  mapper.myTimerDbModelListToEntityList(timerDao.getAllTimers())
    }

    override fun getTimerUseCase(myTimerId: Int): MyTimer {
        return mapper.myTimerDbModelToEntity(timerDao.getTimer(myTimerId))
    }
}