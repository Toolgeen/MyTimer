package com.abdykadyr.mytimer.presentation

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdykadyr.mytimer.R
import com.abdykadyr.mytimer.databinding.MyTimerItemBinding
import com.abdykadyr.mytimer.domain.MyTimer

class TimerListAdapter :
    ListAdapter<MyTimer, TimerListAdapter.TimerItemViewHolder>(TimerDiffCallback()) {

    class TimerItemViewHolder(
        val binding: MyTimerItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimerItemViewHolder {
        val binding = MyTimerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TimerItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimerItemViewHolder, position: Int) {
        val myTimer = getItem(position)
        with(holder.binding) {
            tvMyTimerId.text = myTimer.id.toString()
            tvMyTimerPlannedTime.text = formatTime((myTimer.plannedTime - myTimer.spentTime))
            tvMyTimerStatus.text = when (myTimer.isDone) {
                true -> "done"
                false -> ""
            }
            if (myTimer.whenStartedTime == 0) {
                buttonStartTimer.setBackgroundResource(R.drawable.ic_baseline_timer_24)
            } else {
                buttonStartTimer.setBackgroundResource(R.drawable.ic_baseline_timer_off_24)
            }

        }
    }

    private fun formatTime(time: Int): String
    {
        return DateUtils.formatElapsedTime(time.toLong())
//        return "${time / 3600}:${time % 3600 / 60}:${time % 60}"
    }
}