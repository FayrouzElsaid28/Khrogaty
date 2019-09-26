package roqay.task.khrogaty.features

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import roqay.task.khrogaty.BlankFragment
import roqay.task.khrogaty.features.homeFragments.activities.ToDoFragment
import roqay.task.khrogaty.features.homeFragments.home.HomeFragment
import roqay.task.khrogaty.features.homeFragments.places.FindPlacesFragment
import roqay.task.khrogaty.features.homeFragments.restaurants.RestaurantsFragment
import roqay.task.khrogaty.features.homeFragments.search.SearchFragment

@Suppress("DEPRECATION")
class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> SearchFragment()
            2 -> FindPlacesFragment()
            3 -> RestaurantsFragment()
            4 -> ToDoFragment()
            else -> BlankFragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }
}