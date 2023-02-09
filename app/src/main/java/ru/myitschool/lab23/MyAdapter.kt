package ru.myitschool.lab23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: List<Student>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    class MyView(v: View): RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.random_number_result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.name.text = list.get(position).name
    }
}