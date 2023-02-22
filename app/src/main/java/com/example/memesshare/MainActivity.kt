package com.example.memesshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var imgMemes : ImageView
    lateinit var btnNext : Button
    lateinit var btnShare:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgMemes = findViewById(R.id.imgMemes)
        btnNext = findViewById(R.id.btnNext)
        btnShare = findViewById(R.id.btnShare)

        btnNext.setOnClickListener {  }

        btnShare.setOnClickListener {  }

        loadMeme()
    }

    fun loadMeme() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.imgflip.com/get_memes"

// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,"https://api.imgflip.com/get_memes",null,
            { response ->
                 // Display the first 500 characters of the response string.
             //   Toast.makeText(this,"Response is: ${response.substring(0, 500)}",Toast.LENGTH_LONG).show()
                 response.getJSONArray("https://api.imgflip.com/get_memes")
                 Glide.with(this).load("https://api.imgflip.com/get_memes").into(imgMemes)
             },
            {    Toast.makeText(this,"That didn't work!!!",Toast.LENGTH_LONG).show() })


// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }
}