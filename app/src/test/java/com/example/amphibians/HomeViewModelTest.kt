package com.example.amphibians

import com.example.amphibians.fake.FakeAmphibianRepository
import com.example.amphibians.fake.FakeDataSourse
import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.screens.home.HomeUiState
import com.example.amphibians.ui.screens.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibianViewModel_getAmphibiansInfo_verifyAmphibianUiStateSuccess() =
        runTest {
            val homeViewModel = HomeViewModel(FakeAmphibianRepository())
            assertEquals(HomeUiState.Success(FakeDataSourse.fakeListOfAphibians), homeViewModel.homeUiState)
        }
}