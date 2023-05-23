package com.example.amphibians

import com.example.amphibians.data.NetworkAmphibianRepository
import com.example.amphibians.fake.FakeAmphibianApiService
import com.example.amphibians.fake.FakeDataSourse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkMarsPhotosRepositoryTest(){
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun networkAmphibianRepositoryTest_getAmphibiansInfo_verifyAmphibianList() =
        runTest {
            val repository = NetworkAmphibianRepository(
                FakeAmphibianApiService()
            )
            assertEquals(FakeDataSourse.fakeListOfAphibians, repository.getAmphibiansInfo())
        }
}
