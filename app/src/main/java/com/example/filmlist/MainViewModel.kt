package com.example.filmlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlist.model.Actor
import com.example.filmlist.model.Films
import com.example.filmlist.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var responseFilms: MutableLiveData<Response<Films>> = MutableLiveData()
    var responseActors: MutableLiveData<Response<Actor>> = MutableLiveData()

    fun getFilms() {
        viewModelScope.launch {
            val response = repository.getFilm()
            responseFilms.value = response
        }
    }

    fun getActors() {
        viewModelScope.launch {
            val response = repository.getActor()
            responseActors.value = response
        }
    }
}