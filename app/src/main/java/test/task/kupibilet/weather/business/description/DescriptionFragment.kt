package test.task.kupibilet.weather.business.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_description.*
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.data.local.database.entity.Weather

class DescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Weather>(WEATHER)?.let { description.text = it.toString() }
    }

    companion object {

        private const val WEATHER = "WEATHER"

        fun instance(weather: Weather) = DescriptionFragment().apply {
            arguments = Bundle().apply {
                putParcelable(WEATHER, weather)
            }
        }
    }
}