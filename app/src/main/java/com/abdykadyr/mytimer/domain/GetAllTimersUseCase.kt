package com.abdykadyr.mytimer.domain

import javax.inject.Inject

class GetAllTimersUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke() = repository.getAllTimersUseCase()
}