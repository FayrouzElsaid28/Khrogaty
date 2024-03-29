package roqay.task.khrogaty.view.features.home.homeFragments.home.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.view.features.details.CategoryDetails
import roqay.task.khrogaty.view.features.home.homeFragments.ICategory
import roqay.task.khrogaty.models.activity.Activity

class ToDoAdapter(private val callBack: AdapterToViewCallBack,
                  private val categoryCallCallback: ICategory):
    RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    var todo_list = ArrayList<Activity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return todo_list.size
    }

    fun setData(newData: ArrayList<Activity>){
        todo_list = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image_url = todo_list[position].better_featured_image.source_url
        Picasso.with(callBack.getContext()).load(image_url).into(holder.category_img)
        holder.category_name.text = todo_list[position].title.rendered
        holder.category_place.text = todo_list[position].acf.address

        holder.item_category.setOnClickListener {
            setDetailsData(todo_list[position])
            categoryCallCallback.openActivity()
        }
    }

    private fun setDetailsData(activity: Activity) {
        CategoryDetails.details_name = activity.title.rendered
        CategoryDetails.details_email = activity.acf.email_address
        CategoryDetails.details_img_url = activity.better_featured_image.source_url
        CategoryDetails.details_information = activity.excerpt.rendered
        CategoryDetails.details_map_location_url = activity.acf.map_location
        CategoryDetails.details_phone = activity.acf.phone_number
        CategoryDetails.details_place = activity.acf.address
        CategoryDetails.post_id = activity.better_featured_image.post
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_img = itemView.findViewById<ImageView>(R.id.category_img)
        var category_name = itemView.findViewById<TextView>(R.id.category_name)
        var category_place = itemView.findViewById<TextView>(R.id.category_place)
        var item_category = itemView.findViewById<ConstraintLayout>(R.id.item_category)
    }
}