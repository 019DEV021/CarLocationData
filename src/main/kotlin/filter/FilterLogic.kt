package main.kotlin.filter

import main.kotlin.data.CarLocationRecord

class FilterLogic {

    private val allowedTypes = setOf("SEDAN", "EV", "HATCHBACK")

    fun filter(records: List<CarLocationRecord>): List<CarLocationRecord> {

        return records.filter { record ->

            val validType = allowedTypes.contains(record.vehicleType.uppercase())

            val validLat = record.latitude in -90.0..90.0
            val validLon = record.longitude in -180.0..180.0

            validType && validLat && validLon
        }
    }
}
