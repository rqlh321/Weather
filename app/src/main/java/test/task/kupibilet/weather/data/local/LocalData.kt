package test.task.kupibilet.weather.data.local

import test.task.kupibilet.weather.data.local.database.SQLiteDatabase
import test.task.kupibilet.weather.data.local.res.ResProvider
import javax.inject.Inject

class LocalData @Inject constructor(
    val res: ResProvider,
    val database: SQLiteDatabase
)