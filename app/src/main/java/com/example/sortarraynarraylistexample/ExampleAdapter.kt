package com.example.sortarraynarraylistexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ExampleAdapter(val mExampleList : ArrayList<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    //코틀린에서 내부클래스는 자동적으로 정적클래스로 생성된다고 애기했지...
    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView
        var mTextView1 : TextView
        var mTextView2 : TextView
        init {
            mImageView = itemView.findViewById(R.id.imageView)
            mTextView1 = itemView.findViewById(R.id.textview)
            mTextView2 = itemView.findViewById(R.id.textview2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)
        val exampleViewHolder : ExampleViewHolder = ExampleViewHolder(v)
        return exampleViewHolder
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem : ExampleItem = mExampleList.get(position)
        holder.mTextView1.setText(currentItem.getText1())
        holder.mTextView2.setText(currentItem.getText2())
        holder.mImageView.setImageResource(currentItem.getImageResource())
    }

    override fun getItemCount(): Int {
        return mExampleList.size
    }
}