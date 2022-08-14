package com.example.filmlist.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmlist.MainViewModel
import com.example.filmlist.MainViewModelFactory
import com.example.filmlist.adapters.FilmsAdapter
import com.example.filmlist.databinding.FragmentFilmsListBinding
import com.example.filmlist.repository.Repository


class FilmsListFragment : Fragment() {

    lateinit var binding: FragmentFilmsListBinding
    lateinit var viewModel: MainViewModel
    val adapter by lazy { FilmsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilmsListBinding.inflate(inflater, container, false)

        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getFilms()
        viewModel.filmsLiveData.observe(viewLifecycleOwner) { response ->
            adapter.setData(response.items)
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }



    companion object {
        @JvmStatic
        fun newInstance() = FilmsListFragment()

        fun showDefaultDialog(context: Context, massage:  String) {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.apply {
                setTitle(massage)
            }.create().show()
        }

    }

}