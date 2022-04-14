package com.example.baseproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseproject.R
import com.example.baseproject.data.network.Api
import com.example.baseproject.data.repositories.LocationRepository
import com.example.baseproject.databinding.FragmentDataBinding
import com.example.baseproject.ui.DataViewModel
import com.example.baseproject.ui.LocationAdapter
import com.example.baseproject.utils.Listener

class DataFragment : Fragment(), Listener {
    private var rvLocation: RecyclerView? = null
    private var pgLoading: ProgressBar? = null
    private lateinit var dataViewModel: DataViewModel
    private lateinit var binding: FragmentDataBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(layoutInflater, container, false)

        val api = Api.getInstance()
        val repository = LocationRepository(api)

        dataViewModel = DataViewModel(repository)

        val adapter = LocationAdapter()
        binding.rvLocations.adapter = adapter
        binding.rvLocations.layoutManager = LinearLayoutManager(context)

        dataViewModel.locationList.observe(viewLifecycleOwner, { adapter.setData(it) })
        dataViewModel.errorMessage.observe(
            viewLifecycleOwner,
            { Toast.makeText(context, it, Toast.LENGTH_LONG).show() })

        dataViewModel.loading.observe(viewLifecycleOwner,  {
            if (it) {
                binding.pgLoading.visibility = View.VISIBLE
            } else {
                binding.pgLoading.visibility = View.GONE
            }
        })

        dataViewModel.getLocations()

        return binding.root
    }

    override fun onStarted() {

    }

    override fun onSuccess() {

    }

    override fun onError() {

    }

}