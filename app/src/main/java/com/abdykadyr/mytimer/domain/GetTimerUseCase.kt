package com.abdykadyr.mytimer.domain

class GetTimerUseCase(private val repository: Repository) {
    operator fun invoke(timerId: Int) = repository.getTimerUseCase(timerId)
}