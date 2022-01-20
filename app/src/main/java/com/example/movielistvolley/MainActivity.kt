package com.example.movielistvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
const val url: String = "http://192.168.18.127/movies android app/load_your_json_file.php"
class MainActivity : AppCompatActivity() {
    lateinit var adaptar: NewsAdaptar
    lateinit var mRecyclerView: RecyclerView
    private var mList = mutableListOf<Movie>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recylerView)
        mRecyclerView.setHasFixedSize(true)
        adaptar = NewsAdaptar(this@MainActivity, mList)
        mRecyclerView.adapter = adaptar
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        getNews()

    }
    private fun getNews() {
        val request = StringRequest(
            Request.Method.GET, url,
            { response ->
                Log.d("jm",response.toString())

                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                var mMovies : Array<Movie> = gson.fromJson(response,Array<Movie>::class.java)
                mList.addAll(mMovies)
                adaptar.notifyDataSetChanged()
            },
            { volleyError ->
                Toast.makeText(this, volleyError.message, Toast.LENGTH_SHORT).show()
            })
        Volley.newRequestQueue(this).add(request)
    }

}