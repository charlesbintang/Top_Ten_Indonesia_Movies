package com.charles.toptenindonesiamovies

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About Me"

        val profile = resources.obtainTypedArray(R.array.author_photo)
        val image: ImageView = findViewById(R.id.about_image)
        image.setImageResource(profile.getResourceId(0, -1))

    }

}