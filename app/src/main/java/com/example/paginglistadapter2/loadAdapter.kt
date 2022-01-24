package com.example.paginglistadapter2

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class loadAdapter(private val retry:()->Unit):LoadStateAdapter<loadViewHolder>() {

    override fun onBindViewHolder(holder: loadViewHolder, loadState: LoadState) {
        holder.bind_data(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): loadViewHolder {
        return loadViewHolder.createview(parent,retry)
    }
}