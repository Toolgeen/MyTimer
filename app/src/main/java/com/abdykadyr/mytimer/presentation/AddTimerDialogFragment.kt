package com.abdykadyr.mytimer.presentation

import android.app.AlertDialog
import android.app.Application
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.abdykadyr.mytimer.R
import com.abdykadyr.mytimer.databinding.AddTimerDialogBinding
import java.lang.RuntimeException
import kotlin.math.min

class AddTimerDialogFragment : DialogFragment(R.layout.add_timer_dialog) {

    private var _binding: AddTimerDialogBinding? = null
    private val binding: AddTimerDialogBinding
        get() {
            return _binding ?: throw RuntimeException("AddTimerDialogBinding is null")
        }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = AddTimerDialogBinding.inflate(layoutInflater)
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.add_timer_dialog)
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddTimerDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "AddTimerDialog"
    }
}