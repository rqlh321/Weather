package test.task.kupibilet.weather.business.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.android.support.DaggerAppCompatDialogFragment
import kotlinx.android.synthetic.main.fragment_weather.*
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.business.description.DescriptionFragment
import test.task.kupibilet.weather.common.Named
import test.task.kupibilet.weather.data.local.database.entity.Weather
import test.task.kupibilet.weather.data.local.res.entity.City
import javax.inject.Inject

class WeatherFragment : DaggerAppCompatDialogFragment(),
    Named,
    WeatherContract.View {

    @Inject
    override lateinit var presenter: WeatherContract.Presenter

    private lateinit var adapter: WeatherAdapter

    override fun title() = arguments?.getParcelable<City>(CITY)?.let { "${it.country} - ${it.name}" } ?: ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city = arguments!!.getParcelable<City>(CITY)!!
        presenter.city = city

        adapter = WeatherAdapter(presenter)
        weather.adapter = adapter
        weather.setHasFixedSize(true)
        weather.layoutManager = LinearLayoutManager(context)

        if (savedInstanceState == null) {
            val refreshListener = SwipeRefreshLayout.OnRefreshListener { presenter.checkData() }
            refresh.setOnRefreshListener(refreshListener)

            refresh.post {
                refresh.isRefreshing = true
                refreshListener.onRefresh()
            }

        }
    }

    override fun putData(data: List<Weather>) {
        refresh.isRefreshing = false
        adapter.list.apply {
            clear()
            addAll(data)
        }
        adapter.notifyDataSetChanged()
    }

    override fun showDescription(weather: Weather) {
        parentFragment?.fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.main_body,DescriptionFragment.instance(weather))
            ?.addToBackStack(null)
            ?.commit()
    }

    companion object {

        private const val CITY = "CITY"

        fun instance(city: City) = WeatherFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CITY, city)
            }
        }

    }

}