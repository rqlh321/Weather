package test.task.kupibilet.weather.business.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.common.Named

class CreateLocationFragment : Fragment(), Named {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun title() = "+"

}