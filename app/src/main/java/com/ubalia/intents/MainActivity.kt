package com.ubalia.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        Intent(Intent.ACTION_VIEW, webpage).also {
            if (it.resolveActivity(packageManager) != null) {
                startActivity(it)
            }
        }
    }

    val getContent = registerForActivityResult(GetContent()) { uri: Uri? ->
        Log.d("MainActivity", "Got following uri : ${uri}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnWeb).setOnClickListener {
            openWebPage("https://nickelodeon.fandom.com/wiki/SpongeBob_SquarePants_(character)")
        }

        findViewById<ImageView>(R.id.ivPicture).setOnClickListener {

        }
    }
}