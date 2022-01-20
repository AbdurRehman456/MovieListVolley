package com.example.movielistvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(){
    private var extras: Bundle? = null
    lateinit var img:ImageView
    lateinit var mtitle:TextView
    lateinit var mrating:TextView
    lateinit var moverview:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    img = findViewById(R.id.imageViewdetails)
    mtitle = findViewById(R.id.mTitle)
    mrating = findViewById(R.id.newsratingDetails)
    moverview = findViewById(R.id.newsOverview)

       val rating = intent.getDoubleExtra("rating",0.1)
       val title1 = intent.getStringExtra("title")
       val overView = intent.getStringExtra("overview")
       val poster = intent.getStringExtra("poster")

        Glide.with(this).load(poster).into(img)
        mtitle.setText(title1)
        mrating.setText(rating.toString())
        moverview.setText(overView)
    }

}
