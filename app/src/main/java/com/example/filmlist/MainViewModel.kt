package com.example.filmlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmlist.model.Actor
import com.example.filmlist.model.Films
import com.example.filmlist.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception

class MainViewModel(private val repository: Repository): ViewModel() {

    private val _filmsLiveData: MutableLiveData<Films> = MutableLiveData()
    private val _actorsLiveData: MutableLiveData<Actor> = MutableLiveData()
    val filmsLiveData: LiveData<Films>
        get() = _filmsLiveData
    val actorsLiveData: LiveData<Actor>
        get() = _actorsLiveData
    //var responseFilms: MutableLiveData<Response<Films>> = MutableLiveData()
    //var responseActors: MutableLiveData<Response<Actor>> = MutableLiveData()

    fun getFilms() {
        viewModelScope.launch {

            try {
                val response = repository.getFilm()
                _filmsLiveData.value = response
            } catch (e: Exception) {

            }

        }
    }

    fun getActors() {
        viewModelScope.launch {

            try {
                val response = repository.getActor()
                _actorsLiveData.value = response
            }catch (e: Exception) {

            }

        }
    }
}