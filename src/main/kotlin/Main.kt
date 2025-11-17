package main.kotlin

import main.kotlin.data.CarLocationRecord
import main.kotlin.filter.FilterLogic
import main.kotlin.search.DummyVehicleSearchService


fun main() {

    println("Starting application...")

    val inputData = listOf(
        CarLocationRecord("1", 19.0, 72.0, "SEDAN"),
        CarLocationRecord("2", 22.0, 88.0, "EV"),
        CarLocationRecord("3", -40.0, 100.0, "HATCHBACK"),
        CarLocationRecord("4", 200.0, 72.0, "SEDAN") // invalid lat
    )

    val filter = FilterLogic()
    val validVehicles = filter.filter(inputData)

    println("Valid filtered vehicles:")
    validVehicles.forEach { println(it) }

    val vehicleReqService = DummyVehicleSearchService()

    validVehicles.forEach { vehicle ->
        val vehicleReq = vehicleReqService.findNearby(vehicle)
        println("Near by ${vehicle.vehicleId}: $vehicleReq")
    }
}
