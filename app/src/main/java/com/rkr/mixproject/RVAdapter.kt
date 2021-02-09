package com.rkr.mixproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_row.view.*

class RVAdapter : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvTitle = view.tv_title
        var tv_desc = view.tv_desc
        var iv_ = view.iv_
        fun bind(xx: RecyclerData) {
            tvTitle.text = xx.name
            if (xx?.description==null) {
                tv_desc.text = "Description is not available"
            } else {
                tv_desc.text = xx.description
            }
            val url=xx.owner.avatar_url
            Glide.with(iv_)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)//in case of default image
                .error(R.drawable.ic_launcher_background)//in case of error
                .fallback(R.drawable.ic_launcher_background)//if there is no internet
                .into(iv_)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listss.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listss[position])
    }

    fun setListData(data: ArrayList<RecyclerData>) {
        this.listss = data
    }

    var listss = ArrayList<RecyclerData>()

}