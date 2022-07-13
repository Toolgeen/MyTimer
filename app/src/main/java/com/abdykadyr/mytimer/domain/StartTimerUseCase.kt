package com.abdykadyr.mytimer.domain

import javax.inject.Inject


class StartTimerUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.startTimerUseCase(myTimer)
}