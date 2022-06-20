package com.abdykadyr.mytimer.domain

class StartTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.startTimerUseCase(myTimer)
}