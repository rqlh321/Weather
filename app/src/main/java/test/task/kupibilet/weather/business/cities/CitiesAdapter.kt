package test.task.kupibilet.weather.business.cities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import test.task.kupibilet.weather.business.create.CreateLocationFragment
import test.task.kupibilet.weather.business.weather.WeatherFragment
import test.task.kupibilet.weather.common.Named
import test.task.kupibilet.weather.data.local.res.entity.City

class CitiesAdapter(fm: FragmentManager, cities: List<City>) : FragmentPagerAdapter(fm) {

    private val fragments = cities.map { WeatherFragment.instance(it) }
        .toMutableList<Fragment>()
        .apply { add(CreateLocationFragment()) }

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int): String {
        val fragment = fragments[position]
        return if (fragment is Named) fragment.title() else ""
    }

}