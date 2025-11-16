package test.kotlin

import junit.framework.TestCase.assertEquals
import main.kotlin.data.CarLocationRecord
import main.kotlin.storage.LocationHistoryStorage
import org.junit.Test

class LocationHistoryStorageTest {

    @Test
    fun keepsOnlyLast1000() {
        val storage = LocationHistoryStorage()

        for (i in 1..100) {
            storage.save(CarLocationRecord(12.0, 77.0, i.toLong()))
        }

        assertEquals(100, storage.getAll().size)
    }
}