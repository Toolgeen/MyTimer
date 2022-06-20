package com.abdykadyr.mytimer.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.abdykadyr.mytimer.domain.MyTimer

class Mapper {

    fun myTimerDbModelToEntity(myTimerDbModel: MyTimerDbModel) = MyTimer(
        myTimerDbModel.id,
        myTimerDbModel.plannedTime,
        myTimerDbModel.spentTime,
        myTimerDbModel.whenStartedTime,
        myTimerDbModel.isDone
    )

    fun myTimerEntityToDbModel(myTimer: MyTimer) = MyTimerDbModel(
        myTimer.id,
        myTimer.plannedTime,
        myTimer.spentTime,
        myTimer.whenStartedTime,
        myTimer.isDone
    )

    fun myTimerDbModelListToEntityList(list : LiveData<List<MyTimerDbModel>>) =
        Transformations.map(list) {
            it.map {
                myTimerDbModelToEntity(it)
            }
        }

}