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

    private var filmsList = emptyList<Films>()
//    private var directorsList = emptyList<Item>()
//    private var actorsList = emptyList<Actor>()

    class FilmsViewHolder(
        val binding: ListItemBinding
    ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)

        return FilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.binding.filmName.text = filmsList[position].items.toString()
//        holder.binding.directorName.text = directorsList[position].directorName.toString()
//        holder.binding.actors.text = actorsList[position].actorName.toString()
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(
        newFilmList: Films)
//        //newDirectorsList: List<Item>,
//        newActorsList: Actor)
                                    {

        filmsList = listOf(newFilmList)
//        //directorsList = newDirectorsList
//        actorsList = listOf(newActorsList)

        notifyDataSetChanged()

    }

}