package com.abdykadyr.mytimer.domain

class GetAllTimersUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getAllTimersUseCase()
}