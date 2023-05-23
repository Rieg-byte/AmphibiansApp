package com.example.amphibians

import com.example.amphibians.fake.FakeAmphibianRepository
import com.example.amphibians.fake.FakeDataSourse
import com.example.amphibians.rules.TestDispatcherRule
import com.example.amphibians.ui.theme.screens.AmphibianUiState
import com.example.amphibians.ui.theme.screens.AmphibianViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibianViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibianViewModel_getAmphibiansInfo_verifyAmphibianUiStateSuccess() =
        runTest {
            val amphibianViewModel = AmphibianViewModel(FakeAmphibianRepository())
            assertEquals(AmphibianUiState.Success(FakeDataSourse.fakeListOfAphibians), amphibianViewModel.amphibianUiState)
        }
}