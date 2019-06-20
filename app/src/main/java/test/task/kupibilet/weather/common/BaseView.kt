package test.task.kupibilet.weather.common

interface BaseView<Presenter, Data> {

    var presenter: Presenter

    fun putData(data: Data)

    fun error(message: String)

}