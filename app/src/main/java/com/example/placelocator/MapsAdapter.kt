package com.example.placelocator

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placelocator.models.Place
import com.example.placelocator.models.UserMap

private const val TAG ="MapsAdapter"

class MapsAdapter(val context: Context, val userMaps:List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {
    interface OnClickListener {
        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usersMap = userMaps[position]
        holder.itemView.setOnClickListener {
            Log.i(TAG,"Position is: $position")
            onClickListener.onItemClick(position)
            //
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text = usersMap.title
    }

    override fun getItemCount() = userMaps.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
