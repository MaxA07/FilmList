package com.example.filmlist.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmlist.MainViewModel
import com.example.filmlist.MainViewModelFactory
import com.example.filmlist.adapters.FilmsAdapter
import com.example.filmlist.adapters.OnItemClickListener
import com.example.filmlist.databinding.FragmentFilmsListBinding
import com.example.filmlist.model.Films
import com.example.filmlist.repository.Repository

class FilmsListFragment : Fragment() {

    lateinit var binding: FragmentFilmsListBinding
    lateinit var viewModel: MainViewModel
    private lateinit var adapter: FilmsAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsListBinding.inflate(inflater, container, false)

//        adapter = FilmsAdapter(object: OnItemClickListener {
//            override fun onItemClick(films: Films) {
//                Toast.makeText(requireContext(), "Film:", Toast.LENGTH_SHORT).show()
//            }
//        }


        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getFilms()
        viewModel.filmsLiveData.observe(viewLifecycleOwner) { response ->
            adapter.setData(response.items)
            //binding.recyclerView.addOnItemTouchListener()
        }
        //adapter.onClick(binding.recyclerView)

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        @JvmStatic
        fun newInstance() = FilmsListFragment()
    }
}