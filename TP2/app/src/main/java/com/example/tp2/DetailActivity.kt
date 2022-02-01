package com.example.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.info_task.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_task)

        var intent =this.intent
        tvInfoTitle.text = intent.getStringExtra(Constants.TITLE)
        tvInfoDuration.text = intent.getIntExtra(Constants.DURATION,0).toString()+" min"
        tvInfoDescription.text = intent.getStringExtra(Constants.DESCRIPTION)
        tvInfoCategory.text = intent.getStringExtra(Constants.CATEGORY)
        ivInfoIcon.setImageResource(intent.getIntExtra(Constants.ICON,0))
    }
}