package test.task.kupibilet.weather.business.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_weather.*
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.common.Named
import test.task.kupibilet.weather.data.local.res.entity.City

class WeatherFragment : Fragment(), Named {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city = arguments!!.getParcelable<City>(CITY)!!

        if (savedInstanceState == null) {
            val refreshListener = SwipeRefreshLayout.OnRefreshListener {
                Toast.makeText(context,"",Toast.LENGTH_LONG).show()
            }
            refresh.setOnRefreshListener(refreshListener)

            refresh.post {
                refresh.isRefreshing = true
                refreshListener.onRefresh()
            }

        }
    }

    override fun title() = arguments?.getParcelable<City>(CITY)?.let { "${it.country} - ${it.name}" } ?: ""

    companion object {

        private const val CITY = "CITY"

        fun instance(city: City) = WeatherFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CITY, city)
            }
        }

    }

}