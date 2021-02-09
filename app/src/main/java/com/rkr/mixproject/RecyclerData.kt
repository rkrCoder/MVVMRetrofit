package com.rkr.mixproject


data class RecyclerList (var items:ArrayList<RecyclerData>)
data class RecyclerData (val name:String,val description:String, val owner: Owner)
data class Owner (var avatar_url:String)