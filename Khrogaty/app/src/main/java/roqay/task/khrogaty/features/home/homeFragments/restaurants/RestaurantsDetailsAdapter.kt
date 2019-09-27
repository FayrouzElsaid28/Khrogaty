package roqay.task.khrogaty.features.home.homeFragments.restaurants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.features.details.CategoryDetails
import roqay.task.khrogaty.features.home.homeFragments.ICategory
import roqay.task.khrogaty.models.restaurant.Restaurant

class RestaurantsDetailsAdapter(private val callBack: AdapterToViewCallBack,
                                private val categoryCallCallback: ICategory):
    RecyclerView.Adapter<RestaurantsDetailsAdapter.ViewHolder>() {

    var restaurants_list = ArrayList<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category_details,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return restaurants_list.size
    }

    fun setData(newData: ArrayList<Restaurant>){
        restaurants_list = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image_url = restaurants_list[position].better_featured_image.source_url
        Picasso.with(callBack.getContext()).load(image_url).into(holder.category_img)
        holder.category_name.text = restaurants_list[position].title.rendered
        holder.category_place.text = restaurants_list[position].acf.address
        holder.category_details.text = restaurants_list[position].excerpt.rendered
        holder.details_tv.setOnClickListener {
            setDetailsData(restaurants_list[position])
            categoryCallCallback.openActivity()
        }
    }

    private fun setDetailsData(restaurant: Restaurant) {
        CategoryDetails.details_name = restaurant.title.rendered
        CategoryDetails.details_email = restaurant.acf.email_address
        CategoryDetails.details_img_url = restaurant.better_featured_image.source_url
        CategoryDetails.details_information = restaurant.excerpt.rendered
        CategoryDetails.details_map_location_url = restaurant.acf.map_location
        CategoryDetails.details_phone = restaurant.acf.phone_number
        CategoryDetails.details_place = restaurant.acf.address
        CategoryDetails.post_id = restaurant.better_featured_image.post
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_img = itemView.findViewById<ImageView>(R.id.category_img)
        var category_name = itemView.findViewById<TextView>(R.id.category_name)
        var category_place = itemView.findViewById<TextView>(R.id.category_place)
        var category_details = itemView.findViewById<TextView>(R.id.category_details)
        var details_tv = itemView.findViewById<TextView>(R.id.details_tv)
    }
}