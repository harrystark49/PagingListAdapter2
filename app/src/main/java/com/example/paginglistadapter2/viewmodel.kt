package com.example.paginglistadapter2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paginglistadapter2.networkdata.req_results

class viewmodel :ViewModel() {
    var rinstance:retroInterface
 init {
     rinstance=RetroInstance.retroinst().create(retroInterface::class.java)
 }

    fun getdata():kotlinx.coroutines.flow.Flow<PagingData<req_results>>{
        return Pager(config = PagingConfig(42,maxSize = 200),pagingSourceFactory = {pageSource(rinstance)}).flow.cachedIn(viewModelScope)
    }
}
