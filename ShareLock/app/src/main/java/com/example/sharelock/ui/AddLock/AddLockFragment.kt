package com.example.sharelock.ui.Lock

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


class AddLockFragment : Fragment() {

    private lateinit var addLockViewModel: AddLockViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addLockViewModel =
            ViewModelProviders.of(this).get(AddLockViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_lock, container, false)
        val textView: TextView = root.findViewById(R.id.lock_textView)
        val button: Button = root.findViewById(R.id.lock_button)
        addLockViewModel.changeText().observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        addLockViewModel.switch.observe(viewLifecycleOwner, Observer {
            if (it) {
                button.setBackgroundResource(R.drawable.lock_button)
            } else {
                button.setBackgroundResource(R.drawable.openlock_button)
            }
        })
        addLockViewModel.lock()
        button.setOnClickListener {
            addLockViewModel.lock()
        }
        return root
    }
}