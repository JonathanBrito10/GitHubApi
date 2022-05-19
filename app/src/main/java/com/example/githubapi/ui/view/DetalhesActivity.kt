package com.example.githubapi.ui.view

import android.os.Bundle
import android.text.util.Linkify
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.githubapi.R
import com.squareup.picasso.Picasso


class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

       var imageView = findViewById<ImageView>(R.id.foto)
       var nome = findViewById<TextView>(R.id.nome)
       var link = findViewById<TextView>(R.id.mlink)

        val nomeUsuario = intent.extras!!.getString("name")
        var avatarUrl = intent.extras!!.getString("avatar_url")
        val mlink = intent.extras!!.getString("link")

        link.text = mlink
        Linkify.addLinks(link, Linkify.WEB_URLS)
        nome.text = nomeUsuario

        Picasso.with(this)
            .load(avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(imageView)

    }
}