package test.task.kupibilet.weather.data

import test.task.kupibilet.weather.data.local.database.SQLiteDatabase
import test.task.kupibilet.weather.data.network.NetworkData
import javax.inject.Inject

class Repo @Inject constructor(
    private val network: NetworkData,
    private val database: SQLiteDatabase
)