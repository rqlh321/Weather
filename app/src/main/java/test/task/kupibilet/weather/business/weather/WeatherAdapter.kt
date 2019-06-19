package test.task.kupibilet.weather.business.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_weather.view.*
import test.task.kupibilet.weather.data.local.database.entity.Weather

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    val list = mutableListOf<Weather>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.title.text = item.title
        holder.itemView.timestamp.text = item.timestampPreview
    }

    override fun getItemViewType(position: Int) = list[position].layout()

    override fun getItemCount() = list.size
}