package com.example.amphibians.fake

import com.example.amphibians.data.AmphibianRepository
import com.example.amphibians.model.Amphibian

class FakeAmphibianRepository: AmphibianRepository  {
    override suspend fun getAmphibiansInfo(): List<Amphibian> {
        return FakeDataSourse.fakeListOfAphibians
    }
}