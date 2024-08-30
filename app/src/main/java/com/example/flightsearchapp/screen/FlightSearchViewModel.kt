package com.example.flightsearchapp.screen


import com.example.flightsearchapp.FlightSearchApplication
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.data.AirportDao
import com.example.flightsearchapp.data.FavoriteDao
import com.example.flightsearchapp.data.ImplementRepository
import com.example.flightsearchapp.data.Repository

class FlightSearchViewModel(
   private val repository:Repository
) : ViewModel() {

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
          initializer {
              FlightSearchViewModel(FlightSearchApplication().container.repository)
          }
        }
        }
    }


