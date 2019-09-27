package roqay.task.khrogaty.view.features.home.homeFragments.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.view.features.details.CategoryDetails
import roqay.task.khrogaty.view.features.home.homeFragments.ICategory

class SearchAdapter(private val callBack: AdapterToViewCallBack,
                    private val categoryCallCallback: ICategory
):
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    var search_list = ArrayList<Search>()

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
        return search_list.size
    }

    fun setData(newData: ArrayList<Search>){
        search_list = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image_url = search_list[position].search_img_url
        Picasso.with(callBack.getContext()).load(image_url).into(holder.category_img)
        holder.category_name.text = search_list[position].search_name
        holder.category_place.text = search_list[position].search_place
        holder.category_details.text = search_list[position].search_information
        holder.details_tv.setOnClickListener {
            setDetailsData(search_list[position])
            categoryCallCallback.openActivity()
        }
    }

    private fun setDetailsData(search: Search) {
        CategoryDetails.details_name = search.search_name
        CategoryDetails.details_email = search.search_email
        CategoryDetails.details_img_url = search.search_img_url
        CategoryDetails.details_information = search.search_information
        CategoryDetails.details_map_location_url = search.search_map_location_url
        CategoryDetails.details_phone = search.search_phone
        CategoryDetails.details_place = search.search_place
        CategoryDetails.post_id = search.search_post_id
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_img = itemView.findViewById<ImageView>(R.id.category_img)
        var category_name = itemView.findViewById<TextView>(R.id.category_name)
        var category_place = itemView.findViewById<TextView>(R.id.category_place)
        var category_details = itemView.findViewById<TextView>(R.id.category_details)
        var details_tv = itemView.findViewById<TextView>(R.id.details_tv)
    }
}