package com.senix22.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RelativesAdapter(var items: List<Person>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class ViewType {
        MyView,
        MyParents,
        MyGrandParents,
        MyGreatGrandparents
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewTypeEnum = ViewType.values()[viewType]

        val layout = when (viewTypeEnum) {
            ViewType.MyView -> R.layout.my_layout

            ViewType.MyGrandParents -> R.layout.grandparents_layout

            ViewType.MyGreatGrandparents -> R.layout.grandrelatives

            else -> R.layout.parents_layout

        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return when (viewTypeEnum) {
            ViewType.MyView -> {
                RelativesViewHolder(view)
            }
            ViewType.MyGrandParents -> {
                GrandParentsViewHolder(view)
            }
            ViewType.MyGreatGrandparents -> {
                Grandrelatives(view)
            }
            else -> {
                SecondViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RelativesViewHolder -> holder.bind(items[position])
            is SecondViewHolder -> holder.bind(items[position])
            is GrandParentsViewHolder -> holder.bind(items[position])
            is Grandrelatives -> holder.bind(items[position])
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                ViewType.MyView.ordinal
            }
            2, 5, 7, 8 -> {
                ViewType.MyGrandParents.ordinal
            }
            3, 4, 9 -> {
                ViewType.MyGreatGrandparents.ordinal
            }
            else -> {
                ViewType.MyParents.ordinal
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}