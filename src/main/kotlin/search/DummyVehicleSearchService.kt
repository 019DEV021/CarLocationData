package main.kotlin.search

import main.kotlin.data.CarLocationRecord
import main.kotlin.data.VehicleData

class DummyVehicleSearchService : VehicleSearchService {

    override fun findNearby(location: CarLocationRecord): List<VehicleData> {

        return listOf(
            VehicleData(
                id = "1",
                name = "Restaurant Example",
                type = "RESTAURANT",
                latitude = location.latitude + 0.001,
                longitude = location.longitude + 0.001
            ),
            VehicleData(
                id = "2",
                name = "Charger Example",
                type = "CHARGER",
                latitude = location.latitude + 0.002,
                longitude = location.longitude + 0.002
            )
        )
    }
}