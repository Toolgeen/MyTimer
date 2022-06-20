package com.abdykadyr.mytimer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_list")
data class MyTimerDbModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var plannedTime: Int,
    var spentTime: Int,
    var isDone: Boolean

)
