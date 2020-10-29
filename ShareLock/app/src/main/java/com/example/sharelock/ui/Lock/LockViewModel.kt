package com.example.sharelock.ui.Lock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LockViewModel : ViewModel() {

    private var _text = MutableLiveData<String>()

    private val _alarmText = MutableLiveData<String>()

    private val _switch = MutableLiveData<Boolean>()

    private val _alarmSwitch = MutableLiveData<Boolean>()

    val switch: LiveData<Boolean> = _switch

    fun lock() {
        _switch.value = _switch.value != true
        changeText()
    }

    fun alarm() {
        _alarmSwitch.value = _alarmSwitch.value != true
        changeAlarmText()
    }

    fun changeText(): LiveData<String> {
        if (_switch.value == true) {
            _text.value = "Tap to unlock"
        } else {
            _text.value = "Tap to lock"
        }
        return _text
    }

    fun changeAlarmText(): LiveData<String> {
        if (_alarmSwitch.value == true) {
            _alarmText.value = "Hold to turn on alarm"
        } else {
            _alarmText.value = "Hold to turn off alarm"
        }
        return _alarmText
    }

}