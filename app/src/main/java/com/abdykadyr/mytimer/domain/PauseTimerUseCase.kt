package com.abdykadyr.mytimer.domain

import javax.inject.Inject

class PauseTimerUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.pauseTimerUseCase(myTimer)
}