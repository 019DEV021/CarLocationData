package main.kotlin.search

import main.kotlin.data.CarLocationRecord
import main.kotlin.data.VehicleData

interface VehicleSearchService {
    fun findNearby(location: CarLocationRecord): List<VehicleData>
}