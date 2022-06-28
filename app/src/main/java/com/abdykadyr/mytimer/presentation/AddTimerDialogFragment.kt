package com.abdykadyr.mytimer.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.abdykadyr.mytimer.R

class AddTimerDialogFragment : DialogFragment(R.layout.add_timer_dialog) {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setView(R.layout.add_timer_dialog)
            .setPositiveButton(getString(R.string.ok)) { _,_ -> }
            .create()

    companion object {
        const val TAG = "AddTimerDialog"
    }
}