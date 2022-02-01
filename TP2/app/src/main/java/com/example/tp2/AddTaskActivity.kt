package com.example.tp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var selectedItem: String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        val spinner: Spinner = findViewById(R.id.spAddCategory)
        ArrayAdapter.createFromResource(
            this,
            R.array.categories_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
            btAdd.setOnClickListener {
                val data = Intent()
                data.putExtra(Constants.TITLE,""+ptAddName.text)
                data.putExtra(Constants.DURATION,Integer.parseInt(ptAddDuration.text.toString()))
                data.putExtra(Constants.CATEGORY,""+selectedItem)
                data.putExtra(Constants.DESCRIPTION,""+ptAddDescription.text)
                setResult(Constants.CODE_OK,data)
                finish()
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        selectedItem = resources.getStringArray(R.array.categories_array)[p2]

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}
}