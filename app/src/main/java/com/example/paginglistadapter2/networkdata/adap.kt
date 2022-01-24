package com.example.paginglistadapter2.networkdata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.paginglistadapter2.R
import kotlinx.android.synthetic.main.each_item.view.*
import okhttp3.internal.Util
import java.util.zip.Inflater

class adap:PagingDataAdapter<req_results,adap.view>(load_data()) {
    inner class view(var itemview: View):RecyclerView.ViewHolder(itemview){
        fun bind_data(item: req_results?) {
            itemView.tvName.text=item?.name
            itemView.tvDes.text=item?.species
            Glide.with(itemView.img)
                .load(item?.image)
                .circleCrop()
                .into(itemView.img)
        }

    }

    override fun onBindViewHolder(holder: view, position: Int) {
        holder.bind_data(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view {
        return view(LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false))
    }

    class load_data():DiffUtil.ItemCallback<req_results>(){
        override fun areItemsTheSame(oldItem: req_results, newItem: req_results): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: req_results, newItem: req_results): Boolean {
            return (oldItem.name==newItem.name && oldItem.species==newItem.species)

        }

    }
}