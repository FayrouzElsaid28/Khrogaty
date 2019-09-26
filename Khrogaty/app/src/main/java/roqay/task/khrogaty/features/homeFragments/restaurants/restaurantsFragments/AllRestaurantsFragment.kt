package roqay.task.khrogaty.features.homeFragments.restaurants.restaurantsFragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_all_restaurants.*

import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.base.extensions.makeLongToast
import roqay.task.khrogaty.features.homeFragments.home.Category
import roqay.task.khrogaty.features.homeFragments.restaurants.RestaurantsDetailsAdapter

class AllRestaurantsFragment : Fragment(), AdapterToViewCallBack {

    val restaurantAdapter = RestaurantsDetailsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        all_restaurants_recyclerview.layoutManager = LinearLayoutManager(context)
        all_restaurants_recyclerview.adapter = restaurantAdapter
        getAllRestaurants()

    }

    private fun getAllRestaurants() {
        when(Category.restaurants_list.size){
            0 -> makeLongToast("No restaurants found")
            else -> restaurantAdapter.setData(Category.restaurants_list)
        }
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

}
