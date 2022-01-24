package com.example.paginglistadapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginglistadapter2.networkdata.adap
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.error_row.view.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {
    lateinit var rva:adap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerview()
        initviewmodel()

    }
    fun initRecyclerview() {
        rcv.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            rva = adap()
            var decoration =
                DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            adapter = rva
//                    .withLoadStateHeaderAndFooter(
//                    header = loadAdapter{rva.retry()},
//                    footer = loadAdapter{rva.retry()}
//                )
        }
    }
    fun initviewmodel(){
        var viewmodel=ViewModelProvider(this).get(viewmodel::class.java)
        lifecycleScope.launchWhenCreated {
            viewmodel.getdata().collectLatest {
                rva.submitData(it)
            }
        }

}}