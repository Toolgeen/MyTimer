package com.abdykadyr.mytimer.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.abdykadyr.mytimer.R
import com.abdykadyr.mytimer.databinding.AddTimerDialogBinding

class AddTimerDialogFragment : DialogFragment(R.layout.add_timer_dialog) {

    private lateinit var listener: NoticeDialogListener
    private var hours = 0
    private var minutes = 0

    interface NoticeDialogListener {
        fun onDialogPositiveClick(hours: Int, minutes: Int)
        fun onDialogNegativeClick(dialog: DialogFragment)
    }

    private var _binding: AddTimerDialogBinding? = null
    private val binding: AddTimerDialogBinding
        get() {
            return _binding ?: throw RuntimeException("AddTimerDialogBinding is null")
        }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = AddTimerDialogBinding.inflate(LayoutInflater.from(context))
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.add_timer_dialog)
            .setPositiveButton(R.string.ok) { _, _ ->
                // Send the positive button event back to the host activity
                listener.onDialogPositiveClick(hours, minutes)
            }
            .setNegativeButton(getString(R.string.cancel)) { _, _ ->
                listener.onDialogNegativeClick(this)
            }
            .setView(binding.root)
            .create()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ADD_TIMER_FRAGMENT", "onViewCreated")
        binding.testButton.setOnClickListener {
            Log.d("ADD_TIMER_FRAGMENT", "button from click listener")
        }
        binding.hoursPicker.setOnValueChangedListener { _, _, newVal ->
            hours = newVal
            Log.d("ADD_TIMER_FRAGMENT", "hours $hours")
        }
        binding.minutesPicker.setOnValueChangedListener { _, _, newVal ->
            minutes = newVal
            Log.d("ADD_TIMER_FRAGMENT", "hours $minutes")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = parentFragment as NoticeDialogListener
        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException(
                (context.toString() +
                        " must implement NoticeDialogListener")
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val TAG = "AddTimerDialog"
    }
}