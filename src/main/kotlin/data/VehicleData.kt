package main.kotlin.data

data class VehicleData(
    val id: String,
    val name: String,
    val type: String, // RESTAURANT, CHARGER, SHOP
    val latitude: Double,
    val longitude: Double
)