package test.kotlin

import junit.framework.TestCase.assertEquals
import main.kotlin.data.CarLocationRecord
import main.kotlin.filter.SedanLocationFilter
import org.junit.Test

class SedanLocationFilterTest {

    @Test
    fun removesUnrealisticJump() {
        val filter = SedanLocationFilter()

        val raw = listOf(
            CarLocationRecord(12.0, 77.0, 1000),
            CarLocationRecord(40.0, 90.0, 2000) // Unreal jump
        )

        val result = filter.filter(raw)

        assertEquals(1, result.size)
    }
}
