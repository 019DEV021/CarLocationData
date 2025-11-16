package main.kotlin.filter

import main.kotlin.data.CarLocationRecord


interface LocationFilter {
    fun filter(rawData: List<CarLocationRecord>): List<CarLocationRecord>
}
