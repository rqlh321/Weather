package test.task.kupibilet.weather.business

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import test.task.kupibilet.weather.R
import test.task.kupibilet.weather.business.cities.CitiesFragment

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_body, CitiesFragment())
                .commit()
        }
    }

}
