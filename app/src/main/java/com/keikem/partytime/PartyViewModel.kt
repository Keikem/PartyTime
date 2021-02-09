package com.keikem.partytime

import android.content.Context
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import com.google.gson.Gson
import com.keikem.partytime.data.Party

class PartyViewModel(private val view: Context?, val bindingHelper: BindingHelper) {

    val title = ObservableField("")
    val titleImage = ObservableField("")
    val creatorName = ObservableField("")
    val creatorImage = ObservableField("")
    val items: ObservableList<GuestItemViewModel> = ObservableArrayList()

    init {
        loadData()
    }

    private fun loadData() {
        view?.let { v ->
            val stream = v.assets.open("data.json")
            val size: Int = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()

            val obj = Gson().fromJson(String(buffer), Party::class.java)

            title.set(obj.title)
            titleImage.set(obj.image)
            creatorName.set(obj.creator.name)
            creatorImage.set(obj.creator.image)
            items.addAll(obj.guests.map { GuestItemViewModel(it.name, it.image) })
        }
    }
}