package com.example.smittykittysapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.showevents.models.Event

class MyAdapter(private val data: List<Event>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        fun bind(event: Event) {
          //  val tv = view.findViewById<TextView>(R.id.list_tv)
          //  tv.text = text
            val eventdescription = view.findViewById<TextView>(R.id.event_description)
            val eventdate = view.findViewById<TextView>(R.id.event_date)

            eventdescription.text = event.event_description
            eventdate.text = event.date_of_event
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

}