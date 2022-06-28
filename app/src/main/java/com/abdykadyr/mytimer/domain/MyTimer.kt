package com.abdykadyr.mytimer.domain

data class MyTimer(
    val id: Int = ID_UNDEFINED,
    var plannedTime: Int,
    var spentTime: Int = TIME_NOT_SPENT,
    var whenStartedTime: Int = TIMER_ON_PAUSE,
    var isDone: Boolean = NOT_DONE
) {

    companion object {
        private const val ID_UNDEFINED = 0
        private const val TIME_NOT_SPENT = 0
        private const val NOT_DONE = false
        const val TIMER_ON_PAUSE = 0
    }
}
