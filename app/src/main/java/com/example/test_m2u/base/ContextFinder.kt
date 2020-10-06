package com.example.test_m2u.base

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment
import com.example.test_m2u.custom.activity


interface ContextFinder {

    val cont
        get() : Activity = when (this) {
            is Fragment -> requireContext().activity
            is View -> context.activity
            is Dialog -> context.activity
            else -> this as Activity
        }

}
