package com.example.paginglistadapter2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglistadapter2.databinding.ErrorRowBinding

class loadViewHolder(
    var binding: ErrorRowBinding,
    var retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener {
            retry.invoke()
        }
    }
    fun bind_data(load:LoadState){
        if(load is LoadState.Error){
            binding.errorMsg.text=load.error.localizedMessage
            binding.animation.playAnimation()
        }
        binding.progressBar.isVisible=load is LoadState.Loading
        binding.errorMsg.isVisible=load is LoadState.Error
        binding.retryButton.isVisible=load is LoadState.Error

    }

    companion object {
        fun createview(parent: ViewGroup, retry: () -> Unit): loadViewHolder {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.error_row, parent, false)
            var binding = ErrorRowBinding.bind(view)
            return loadViewHolder(binding, retry)
        }
    }

}