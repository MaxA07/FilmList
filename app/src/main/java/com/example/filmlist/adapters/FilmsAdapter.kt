package com.example.filmlist.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlist.databinding.ListItemBinding
import com.example.filmlist.model.Actor
import com.example.filmlist.model.Films
import com.example.filmlist.model.Item


interface OnItemClickListener {
    fun onItemClick(films: Films)
}


class FilmsAdapter(
    private val actionListener: OnItemClickListener
): RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>(), View.OnClickListener {

    private var filmsList = emptyList<Item>()
    private var actorsList = emptyList<Actor>()

    class FilmsViewHolder(
        val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onClick(v: View) {
        val film = v.tag as Films
        actionListener.onItemClick(film)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return FilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.itemView.tag = filmsList[position]
        holder.binding.filmName.text = filmsList[position].title
        holder.binding.directorName.text = filmsList[position].directorName
        //holder.binding.actors.text = actorsList[position].actorName

    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newFilmList: List<Item>) {
        filmsList = newFilmList
        notifyDataSetChanged()

    }

}