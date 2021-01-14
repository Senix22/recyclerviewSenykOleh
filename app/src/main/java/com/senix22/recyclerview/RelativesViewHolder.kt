package com.senix22.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grandparents_layout.view.*
import kotlinx.android.synthetic.main.grandrelatives.view.*
import kotlinx.android.synthetic.main.my_layout.view.*
import kotlinx.android.synthetic.main.parents_layout.view.*


class RelativesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(text: Person) {
        itemView.textForMe.text = text.toString()

    }
}

class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(text: Person) {
        itemView.textForParents.text = text.toString()
    }
}

class GrandParentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(text: Person) {
        itemView.textForGrandParents.text = text.toString()
    }
}

class Grandrelatives(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(text: Person) {
        itemView.textForGrandRelatives.text = text.toString()
    }
}