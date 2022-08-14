package com.example.filmlist.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlist.databinding.ListItemBinding
import com.example.filmlist.model.Actor
import com.example.filmlist.model.Item
import com.example.filmlist.screens.FilmsListFragment



class FilmsAdapter: RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    private var filmsList = emptyList<Item>()
    private var actorsList = emptyList<Actor>()

    class FilmsViewHolder(
        val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)

        return FilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        val film = filmsList[position]
        holder.binding.filmName.text = film.title
        holder.binding.releaseYear.text = "(${film.releaseYear})"
        holder.binding.directorName.text = film.directorName

        if (film.actors.isNotEmpty()) {
            holder.binding.actors.text = buildString {
                film.actors.forEach {actor ->
                    append(actor.actorName)
                    append(", ")
                }
            }.dropLast(2)
        }

    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    override fun onViewAttachedToWindow(holder: FilmsViewHolder) {
        super.onViewAttachedToWindow(holder)

        val context = holder.itemView.context
        val filmTitle = "Фильм ${holder.binding.filmName.text} был нажат"

        holder.itemView.setOnClickListener {

            Log.d("toast", "click")
            Toast.makeText(context, filmTitle, Toast.LENGTH_SHORT).show()
            FilmsListFragment.showDefaultDialog(holder.itemView.context, filmTitle)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newFilmList: List<Item>) {
        filmsList = newFilmList.sortedBy { it.releaseYear }
        notifyDataSetChanged()

    }

}