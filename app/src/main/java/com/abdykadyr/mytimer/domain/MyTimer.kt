package com.abdykadyr.mytimer.domain

data class MyTimer(
    val id: Int = ID_UNDEFINED,
    var plannedTime: Int,
    var spendTime: Int,
    var isDone: Boolean
) {

    companion object {
        private const val ID_UNDEFINED = 0
    }
}
