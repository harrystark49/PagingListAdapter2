package com.example.paginglistadapter2

import android.net.Uri
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginglistadapter2.networkdata.req_results

class pageSource(var data:retroInterface):PagingSource<Int,req_results>(){

    override fun getRefreshKey(state: PagingState<Int, req_results>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, req_results> {
        return try{

            var pagenum:Int=params.key?:s
        var res=data.getDataFromAPI(pagenum)

        var nextpage:Int?=null
            Log.d("sfs","res is ${res.info}")
        if(res.info.next!=null){
            Log.d("errorss"," errr is fdsf")

            var uri= Uri.parse(res.info.next)
            nextpage=Integer.parseInt(uri.getQueryParameter("page"))
        }
         LoadResult.Page(data = res.reqresults,null,nextKey = nextpage)

        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
    companion object{
        var s=1
    }

}