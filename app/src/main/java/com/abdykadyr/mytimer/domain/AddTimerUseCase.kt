package com.abdykadyr.mytimer.domain

import javax.inject.Inject

class AddTimerUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.addTimerUseCase(myTimer)
}