package com.rkr.mixproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rkr.mixproject.RecyclerList
import com.rkr.mixproject.network.RetroInstance
import com.rkr.mixproject.network.RetroService
import retrofit2.Call
import retrofit2.Response

class RecyclerActivityViewModel : ViewModel() {


    lateinit var recyclerListData: MutableLiveData<RecyclerList>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList> {
        return recyclerListData
    }

    fun makeAPICall(value: String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(value)

        call.enqueue(object : retrofit2.Callback<RecyclerList> {
            override fun onResponse(p0: Call<RecyclerList>?, p1: Response<RecyclerList>?) {
                //rvAdapter.setListData(p1?.body()?.items!!)
                //rvAdapter.notifyDataSetChanged()
                if (p1?.isSuccessful!!) {
                    recyclerListData.postValue(p1?.body())
                } else {
                    recyclerListData.postValue(null)
                }

            }

            override fun onFailure(p0: Call<RecyclerList>?, p1: Throwable?) {
                //Toast.makeText(this@RecyclerviewActivity,"Error in fetchinng from API", Toast.LENGTH_SHORT).show()
                recyclerListData.postValue(null)
            }
        })
    }
}