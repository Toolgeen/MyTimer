package com.abdykadyr.mytimer.domain

import javax.inject.Inject

class EditTimerUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(myTimer: MyTimer) = repository.editTimerUseCase(myTimer)
}