package com.abdykadyr.mytimer.domain

class GetTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimerId: Int) = repository.getTimerUseCase(myTimerId)
}