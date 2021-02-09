package com.keikem.partytime

import androidx.databinding.ObservableField

class GuestItemViewModel(name: String, image: String) {

    val name = ObservableField(name)
    val image = ObservableField(image)
}