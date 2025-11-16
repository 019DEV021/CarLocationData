package main.kotlin.storage

import main.kotlin.data.CarLocationRecord

class LocationHistoryStorage {

    private val records = mutableListOf<CarLocationRecord>()
    private val MAX = 1000

    fun save(record: CarLocationRecord) {
        if (records.size >= MAX) {
            records.removeAt(0)
        }
        records.add(record)
    }

    fun getAll(): List<CarLocationRecord> = records.toList()
}
