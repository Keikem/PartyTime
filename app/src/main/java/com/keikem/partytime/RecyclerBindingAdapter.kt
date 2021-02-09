package com.keikem.partytime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerBindingAdapter<T>(
    private val bindingHelper: BindingHelper,
    private var items: ObservableList<T> = ObservableArrayList(),
    private val onClickAction: (position: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerBindingAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder =
        BindingHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                bindingHelper.layoutRes,
                parent, false
            )
        )

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding.run {
            setVariable(bindingHelper.variableId, items[position])
            root.setOnClickListener { onClickAction(position) }
            executePendingBindings()
        }
    }

    override fun getItemCount() = items.size

    fun setItems(items: ObservableList<T>) {
        synchronized(items) { this.items = items }
        notifyDataSetChanged()
    }

    class BindingHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}
