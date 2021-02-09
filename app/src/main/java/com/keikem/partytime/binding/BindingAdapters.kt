package com.keikem.partytime.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keikem.partytime.BindingHelper
import com.keikem.partytime.R
import com.keikem.partytime.RecyclerBindingAdapter
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("app:bindingHelper")
fun setRecyclerAdapter(recyclerView: RecyclerView, bindingHelper: BindingHelper) {
    if (recyclerView.adapter == null)
        recyclerView.adapter = RecyclerBindingAdapter<Any>(bindingHelper) {}
}

@BindingAdapter("app:items")
fun <T : Any> setRecyclerAdapterItems(recyclerView: RecyclerView, items: ObservableList<T>) {
    (recyclerView.adapter as? RecyclerBindingAdapter<T>)?.setItems(items)
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(view.context).load(url).error(R.drawable.error).into(view)
}

@BindingAdapter("imageUrl")
fun loadImage(view: CircleImageView, url: String?) {
    if (!url.isNullOrEmpty())
        Glide.with(view.context).load(url).error(R.drawable.error).into(view)
}