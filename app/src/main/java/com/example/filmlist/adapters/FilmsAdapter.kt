package com.example.filmlist.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlist.databinding.ListItemBinding
import com.example.filmlist.model.Actor
import com.example.filmlist.model.Films
import com.example.filmlist.model.Item


class FilmsAdapter: RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    private var filmsList = emptyList<Item>()

    class FilmsViewHolder(
        val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)

        return FilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.binding.filmName.text = filmsList[position].title
        holder.binding.directorName.text = filmsList[position].directorName

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