package roqay.task.khrogaty.features.home.homeFragments.restaurants.restaurantsFragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_coffee_shops_only.*

import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.base.extensions.makeLongToast
import roqay.task.khrogaty.base.extensions.openActivtyFromParent
import roqay.task.khrogaty.features.details.DetailsActivity
import roqay.task.khrogaty.features.home.homeFragments.ICategory
import roqay.task.khrogaty.features.home.homeFragments.Category
import roqay.task.khrogaty.features.home.homeFragments.restaurants.RestaurantsDetailsAdapter

class CoffeeShopsOnlyFragment : Fragment(),
    AdapterToViewCallBack,
    ICategory{

    val restaurantAdapter =
        RestaurantsDetailsAdapter(this,this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coffee_shops_only, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coffee_shops_only_recyclerview.layoutManager = LinearLayoutManager(context)
        coffee_shops_only_recyclerview.adapter = restaurantAdapter
        getCoffeShops()

    }

    private fun getCoffeShops() {
        when(Category.restaurants_list.size){
            0 -> makeLongToast("No restaurants found")
            else -> restaurantAdapter.setData(Category.restaurants_list)
        }
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

    override fun openActivity() {
        openActivtyFromParent(DetailsActivity::class.java)
    }

}
