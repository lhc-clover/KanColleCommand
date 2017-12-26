package cn.cctech.kccommand.widgets

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.View

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder

class DataBindingHolder(v: View, isItem: Boolean) : UltimateRecyclerviewViewHolder<Any>(v) {

    lateinit var binding: ViewDataBinding
        private set

    init {
        if (isItem) {
            binding = DataBindingUtil.bind(v)
        }
    }

}