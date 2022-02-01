package com.example.tp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listOfTasks = ArrayList<Task>()
    val adapter by lazy { TaskAdapter(listOfTasks) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTasks()
        rvID.layoutManager = LinearLayoutManager(applicationContext)
        rvID.itemAnimator = DefaultItemAnimator()
        rvID.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        rvID.adapter = adapter
        btAddMain.setOnClickListener {
            val intent = Intent(it.context,AddTaskActivity::class.java)
            startActivityForResult(intent,Constants.REQUEST_CODE)
        }
    }

    private fun initTasks() {
        listOfTasks.add(Task("task1",150,"simple task",Task.Categorie.Other,R.drawable.courses))
        listOfTasks.add(Task("task2",10,"simple task",Task.Categorie.Work,R.drawable.enfant))
        listOfTasks.add(Task("task3",1050,"simple task",Task.Categorie.Other,R.drawable.lecture))
        listOfTasks.add(Task("task4",20,"simple task",Task.Categorie.Children,R.drawable.menage))
        listOfTasks.add(Task("task5",50,"simple task",Task.Categorie.Shopping,R.drawable.point_interro_))
        listOfTasks.add(Task("task6",450,"simple task",Task.Categorie.Other,R.drawable.sport))
        listOfTasks.add(Task("task7",15,"simple task",Task.Categorie.Other,R.drawable.travail))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if((requestCode == Constants.REQUEST_CODE) and (resultCode == Constants.CODE_OK)){
            var task = Task(
                data?.getStringExtra(Constants.TITLE).toString(),
                data?.getIntExtra(Constants.DURATION,0)!!,
                data.getStringExtra(Constants.DESCRIPTION).toString(),
                Task.Categorie.valueOf(data.getStringExtra(Constants.CATEGORY).toString()),
                data.getIntExtra(Constants.CODE_ICON,0))
            listOfTasks.add(task)
            adapter.notifyDataSetChanged()

        }

    }
}