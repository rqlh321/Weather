package test.task.kupibilet.weather.business.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerAppCompatDialogFragment
import kotlinx.android.synthetic.main.fragment_cities.*
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.data.local.res.entity.City
import javax.inject.Inject

class CitiesFragment : DaggerAppCompatDialogFragment(),
    CitiesContract.View {

    @Inject
    override lateinit var presenter: CitiesContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.checkData()
    }

    override fun putData(data: List<City>) {
        pages.adapter = CitiesAdapter(childFragmentManager, data)
        tabs.setupWithViewPager(pages)
    }

}