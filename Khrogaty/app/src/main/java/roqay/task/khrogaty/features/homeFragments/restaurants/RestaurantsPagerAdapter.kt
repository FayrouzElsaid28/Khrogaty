package roqay.task.khrogaty.features.homeFragments.restaurants

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import roqay.task.khrogaty.BlankFragment
import roqay.task.khrogaty.features.homeFragments.restaurants.restaurantsFragments.AllRestaurantsFragment
import roqay.task.khrogaty.features.homeFragments.restaurants.restaurantsFragments.CoffeeShopsOnlyFragment
import roqay.task.khrogaty.features.homeFragments.restaurants.restaurantsFragments.RestaurantsOnlyFragment

@Suppress("DEPRECATION")
class RestaurantsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllRestaurantsFragment()
            1 -> RestaurantsOnlyFragment()
            2-> CoffeeShopsOnlyFragment()
            else -> BlankFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "All"
            1 -> "Restaurants"
            2 -> "Coffee Shops"
            else -> "null"
        }
    }
}