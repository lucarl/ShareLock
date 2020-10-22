package com.example.sharelock.ui.Lock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddLockViewModel : ViewModel() {

    private var _text = MutableLiveData<String>()

    private val _switch = MutableLiveData<Boolean>()

    val switch: LiveData<Boolean> = _switch

    fun lock() {
        _switch.value = _switch.value != true
        changeText()
    }

    fun changeText(): LiveData<String> {
        if (_switch.value == true) {
            _text.value = "Tap to unlock"
        } else {
            _text.value = "Tap to lock"
        }
        return _text
    }


}