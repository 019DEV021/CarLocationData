package main.kotlin.filter

import main.kotlin.data.CarLocationRecord

class SedanLocationFilter : LocationFilter {

    override fun filter(rawData: List<CarLocationRecord>): List<CarLocationRecord> {
        if (rawData.isEmpty()) return rawData

        val result = mutableListOf<CarLocationRecord>()
        var last: CarLocationRecord? = null

        for (item in rawData) {
            if (last == null) {
                result.add(item)
            } else {
                val distance = distanceKm(last!!.latitude, last!!.longitude, item.latitude, item.longitude)
                val timeDiffSec = (item.timestamp - last!!.timestamp).toDouble() / 1000.0
                val speed = distance / (timeDiffSec / 3600.0)

                if (speed < 200) { // Remove unrealistic jumps
                    result.add(item)
                }
            }
            last = item
        }

        return result
    }

    private fun distanceKm(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val earthRadius = 6371.0

        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(lon2 - lon1)

        val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) *
                Math.cos(Math.toRadians(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2)

        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        return earthRadius * c
    }
}


