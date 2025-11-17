package test.kotlin

import junit.framework.TestCase.assertEquals
import main.kotlin.data.CarLocationRecord
import main.kotlin.filter.FilterLogic
import org.junit.Test

class FilterLogicTest {

    @Test
    fun testFilter() {

        val input = listOf(
            CarLocationRecord("1", 19.0, 72.0, "SEDAN"),
            CarLocationRecord("2", 22.0, 88.0, "EV"),
            CarLocationRecord("3", 0.0, 0.0, "HATCHBACK"),
            CarLocationRecord("4", 200.0, 88.0, "SEDAN"), // invalid lat
            CarLocationRecord("5", 19.0, 72.0, "BIKE") // invalid type
        )

        val result = FilterLogic().filter(input)

        assertEquals(3, result.size)
    }
}
