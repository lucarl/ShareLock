package com.example.bikescreenv1

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import com.example.bikescreenv1.utils.Utils

class MainActivity : AppCompatActivity() {

    private var connected:Boolean = false
    private var lockButton:Boolean = false
    private var switch:Boolean = true
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.lock_button)
        val connectButton: Button = findViewById(R.id.connect_button)
        val textView: TextView = findViewById(R.id.lock_textView)
        connectButton.setBackgroundResource(R.drawable.not_connected_button)
        button.setBackgroundResource(R.drawable.camera_button)
        textView.text = "Tap to take photo and request access to bike"

        connectButton.setOnClickListener {
            connected = connected != true
            changeConnected(connectButton, button, textView)
        }

        button.setOnClickListener {
            if (connected) {
                changeLock(button, textView)
            } else {
                dispatchTakePictureIntent()
            }
        }
    }

    private fun changeConnected(connectButton: Button, button: Button, textView: TextView) {
        if (connected) {
            button.setBackgroundResource(R.drawable.lock_button)
            connectButton.setBackgroundResource(R.drawable.connected_button)
            textView.text = "Tap to unlock"
        } else {
            connectButton.setBackgroundResource(R.drawable.not_connected_button)
            button.setBackgroundResource(R.drawable.camera_button)
            textView.text = "Tap to take photo and request access to bike"
        }
    }

    fun changeLock(button: Button, textView: TextView) {
        lockButton = lockButton != true
        if (lockButton) {
            button.setBackgroundResource(R.drawable.openlock_button)
            textView.text = "Tap to lock"
        } else {
            button.setBackgroundResource(R.drawable.lock_button)
            textView.text = "Tap to unlock"
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

}