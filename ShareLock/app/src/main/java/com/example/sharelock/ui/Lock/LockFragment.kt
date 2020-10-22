package com.example.sharelock.ui.Lock

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sharelock.R
import com.example.sharelock.utils.Utils


class LockFragment : Fragment() {

    private lateinit var lockViewModel: LockViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lockViewModel =
            ViewModelProviders.of(this).get(LockViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_lock, container, false)
        val textView: TextView = root.findViewById(R.id.lock_textView)
        val textAlarmView: TextView = root.findViewById(R.id.alarm_textView)
        val button: Button = root.findViewById(R.id.lock_button)
        val buttonPhoto: Button = root.findViewById(R.id.photo_connect)
        val alarmButton: Button = root.findViewById(R.id.alarm_button)
        lockViewModel.changeText().observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        lockViewModel.changeAlarmText().observe(viewLifecycleOwner, Observer {
            textAlarmView.text = it
        })

        lockViewModel.switch.observe(viewLifecycleOwner, Observer {
            if (it) {
                button.setBackgroundResource(R.drawable.lock_button)
            } else {
                button.setBackgroundResource(R.drawable.openlock_button)
            }
        })

        lockViewModel.lock()
        button.setOnClickListener {
            lockViewModel.lock()
        }

        lockViewModel.alarm()
        alarmButton.setOnClickListener {
            lockViewModel.alarm()
        }

        buttonPhoto.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            //set title for alert dialog
            builder.setTitle("This person wants to access your bike right now!")
            //set message for alert dialog

            builder.setIcon(R.drawable.image_dialog)

            //performing positive action
            builder.setPositiveButton("Accept"){dialogInterface, which ->
            }
            //performing cancel action
            builder.setNeutralButton("Decline"){dialogInterface , which ->
            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()

        }

        return root
    }
}