package com.thorin.apps.asmal.view.ui.menu.sholawat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.model.ListSholawatData

class SholawatAsliListAdapter(val context: Context, var courseList: ArrayList<ListSholawatData>) :
    RecyclerView.Adapter<SholawatAsliListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.listaslisholawat_data, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle?.text = courseList[position].sholawatName
        holder.txtContent?.text = courseList[position].sholawatDescrip
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.nama_sholawat)
        val txtContent = itemView.findViewById<TextView>(R.id.isi_sholawat)

        init {

            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, isiSholawatList::class.java).apply {
                    putExtra("EXTRA_NAMA", txtTitle.text)
                    putExtra("EXTRA_ISI", txtContent.text)
                }
                context.startActivity(intent)
            }
        }

    }


    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<ListSholawatData>) {
        this.courseList = filteredCourseList
        notifyDataSetChanged()
    }


}