package com.example.sharelock.ui.Friends

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FriendsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Friends that have access to your bike:"
    }
    val text: LiveData<String> = _text
}