package com.abdykadyr.mytimer.domain

class DeleteTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimerId: Int) = repository.deleteTimerUseCase(myTimerId)
}