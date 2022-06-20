package com.abdykadyr.mytimer.domain

class AddTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.addTimerUseCase(myTimer)
}