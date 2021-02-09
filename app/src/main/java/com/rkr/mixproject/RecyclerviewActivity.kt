package com.rkr.mixproject

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.rkr.mixproject.viewmodel.RecyclerActivityViewModel
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

    lateinit var rvAdapter: RVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        initRV()
        createData()
    }

    private fun initRV() {
        recyclerview.apply {
            layoutManager = LinearLayoutManager(this@RecyclerviewActivity)
            rvAdapter=RVAdapter()
            adapter=rvAdapter


            val decoration=DividerItemDecoration(applicationContext,VERTICAL)
            addItemDecoration(decoration)
        }
    }

    fun createData(){


      val viewModel= ViewModelProviders.of(this).get(RecyclerActivityViewModel::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, Observer<RecyclerList>{
            if (it!=null){
                rvAdapter.setListData(it.items!!)
                rvAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this@RecyclerviewActivity,"Error in fetchinng from API", Toast.LENGTH_SHORT).show()
            }
        })

        btn_search.setOnClickListener { viewModel.makeAPICall(et_place.text.toString()) }

    }

}