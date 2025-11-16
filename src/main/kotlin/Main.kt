package main.kotlin

import main.kotlin.data.CarLocationRecord
import main.kotlin.filter.SedanLocationFilter
import main.kotlin.storage.LocationHistoryStorage

fun main() {

    val rawData = listOf(
        CarLocationRecord(12.0, 77.0, 1000),
        CarLocationRecord(12.0001, 77.0001, 2000),
        CarLocationRecord(35.0, 89.0, 3000), // Unrealistic jump
        CarLocationRecord(12.0002, 77.0002, 4000)
    )

    val filter = SedanLocationFilter()
    val filtered = filter.filter(rawData)

    val storage = LocationHistoryStorage()
    filtered.forEach { storage.save(it) }

    println("RAW DATA:")
    rawData.forEach { println(it) }

    println("\nFILTERED DATA:")
    filtered.forEach { println(it) }

    println("\nSTORED HISTORY:")
    storage.getAll().forEach { println(it) }
}