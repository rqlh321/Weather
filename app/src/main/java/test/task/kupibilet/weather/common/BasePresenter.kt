package test.task.kupibilet.weather.common

interface BasePresenter<View> {

    val view: View

    fun checkData()

}