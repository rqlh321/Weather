package test.task.kupibilet.weather.data.local.res

import android.content.Context
import android.content.res.Resources
import com.google.gson.Gson
import javax.inject.Inject
import kotlin.reflect.KClass

open class ResProvider @Inject constructor(context: Context) {

    private val res: Resources = context.resources

    private val gson = Gson()

    fun string(id: Int): String = res.getString(id)

    fun array(id: Int): Array<String> = res.getStringArray(id)

    fun <T : Any> raw(id: Int, kClass: KClass<T>): T {
        val json = res.openRawResource(id)
            .bufferedReader(Charsets.UTF_8)
            .use { it.readText() }

        return gson.fromJson<T>(json, kClass.java)
    }

}
