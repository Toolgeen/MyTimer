package com.abdykadyr.mytimer.domain

class EditTimerUseCase(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.editTimerUseCase(myTimer)
}