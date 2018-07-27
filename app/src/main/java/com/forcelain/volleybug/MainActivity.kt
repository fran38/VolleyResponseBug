package com.forcelain.volleybug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView
import kotlinx.android.synthetic.main.activity_main.*

const val IMG = "https://developers.google.com/site-assets/developers_64dp.png"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MyAdapter()
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<NetworkImageView>(R.id.image)
        val textView = itemView.findViewById<TextView>(R.id.text)
        val imageLoader = (itemView.context.applicationContext as App).imageLoader
    }

    class MyAdapter : RecyclerView.Adapter<MyHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
            return LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
                    .run { MyHolder(this) }
        }

        override fun getItemCount(): Int = 20

        override fun onBindViewHolder(holder: MyHolder, position: Int) {
            holder.imageView.setImageUrl(IMG, holder.imageLoader)
            holder.textView.text = "Item #$position"
        }
    }
}
