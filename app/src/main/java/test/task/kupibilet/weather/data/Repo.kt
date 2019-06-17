package test.task.kupibilet.weather.data

import test.task.kupibilet.weather.data.local.LocalData
import test.task.kupibilet.weather.data.network.NetworkData
import javax.inject.Inject

class Repo @Inject constructor(
     val network: NetworkData,
     val local: LocalData
)