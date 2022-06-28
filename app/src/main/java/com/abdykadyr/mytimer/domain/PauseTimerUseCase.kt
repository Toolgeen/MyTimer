package com.abdykadyr.mytimer.domain

class PauseTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.pauseTimerUseCase(myTimer)
}