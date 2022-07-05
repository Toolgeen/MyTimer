package com.abdykadyr.mytimer.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdykadyr.mytimer.databinding.FragmentMyTimerListBinding
import com.abdykadyr.mytimer.domain.MyTimer

class TimerListAdapter(callback: TimerDiffCallback) :
    ListAdapter<MyTimer, TimerListAdapter.TaskItemViewHolder>(callback) {

    class TaskItemViewHolder(
        private val binding: FragmentMyTimerListBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val binding = FragmentMyTimerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val myTimer = getItem(position)

    }

    private fun formatTime(time: Int): String {
        return "${time / 3600}:${time / 60}:${time % 60}"
    }
}