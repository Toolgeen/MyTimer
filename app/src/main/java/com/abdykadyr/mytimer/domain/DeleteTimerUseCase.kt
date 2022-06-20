package com.abdykadyr.mytimer.domain

class DeleteTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.deleteTimerUseCase(myTimer)
}