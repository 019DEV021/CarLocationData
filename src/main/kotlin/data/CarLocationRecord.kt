package main.kotlin.data

data class CarLocationRecord(
    val vehicleId: String,
    val latitude: Double,
    val longitude: Double,
    val vehicleType: String // SEDAN, EV, HATCHBACK
)