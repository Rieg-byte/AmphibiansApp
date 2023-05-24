package com.example.amphibians.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibiansApplication
import com.example.amphibians.data.AmphibianRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel(private val amphibianRepository: AmphibianRepository): ViewModel() {
    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getAmphibiansInfo()
    }

    /**
     * Получение информации о амфибиях
     */
    fun getAmphibiansInfo() = viewModelScope.launch {
        homeUiState = HomeUiState.Loading
        homeUiState = try {
            HomeUiState.Success(amphibianRepository.getAmphibiansInfo())
        } catch (e: IOException) {
            HomeUiState.Error
        } catch (e: HttpException) {
            HomeUiState.Error
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibianRepository
                HomeViewModel(amphibianRepository = amphibiansRepository)
            }
        }
    }
}