package com.abdykadyr.mytimer.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TimerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTimer(myTimerDbModel: MyTimerDbModel)

    @Query("SELECT * FROM task_list ORDER BY id")
    fun getAllTimers() : LiveData<List<MyTimerDbModel>>

    @Query("SELECT * FROM task_list WHERE id == :myTimerId")
    fun getTimer(myTimerId : Int) : MyTimerDbModel

    @Delete(entity = MyTimerDbModel::class)
    fun deleteTimer(myTimerDbModel: MyTimerDbModel)

}