package test.kotlin

import junit.framework.TestCase.assertEquals
import main.kotlin.data.CarLocationRecord
import main.kotlin.search.DummyVehicleSearchService
import org.junit.Test

class DummyVehicleSearchServiceTest {

    @Test
    fun testPoiResults() {
        val poiService = DummyVehicleSearchService()
        val record = CarLocationRecord("1", 19.0, 72.0, "SEDAN")

        val pois = poiService.findNearby(record)

        assertEquals(2, pois.size)
    }
}
