package com.example.tp2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(var listTasks: ArrayList<Task>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.view_task, parent, false)
        return ViewHolder(view)

    }

    /**
     * Updating the item at the position @param position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listTasks[position]
        holder.icon.setImageResource(item.code_icon)
        holder.title.text = item.title
        holder.itemView.setOnClickListener {
            var intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(Constants.TITLE,item.title)
            intent.putExtra(Constants.ICON,item.code_icon)
            intent.putExtra(Constants.DURATION,item.duration)
            intent.putExtra(Constants.DESCRIPTION,item.description)
            intent.putExtra(Constants.CATEGORY,item.category.toString())
            it.context.startActivity(intent)
            Log.d("click",item.title+" "+item.duration)
        }
        holder.itemView.setOnLongClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setMessage("Are you sure you want to delete this task?")
                .setPositiveButton("yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        listTasks.removeAt(position)
                        this.notifyDataSetChanged()
                    })
                .setNegativeButton("no",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            builder.create()
            builder.show()
            true
        }

    }

    override fun getItemCount(): Int = listTasks.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var view: View = itemView
        var icon: ImageView = itemView.findViewById(R.id.ivIcon)
        var title: TextView = itemView.findViewById(R.id.tvTitle)
    }


}