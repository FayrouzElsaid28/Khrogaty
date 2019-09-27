package roqay.task.khrogaty.view.features.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import roqay.task.khrogaty.view.BlankFragment
import roqay.task.khrogaty.view.features.home.homeFragments.activities.ToDoFragment
import roqay.task.khrogaty.view.features.home.homeFragments.home.HomeFragment
import roqay.task.khrogaty.view.features.home.homeFragments.places.FindPlacesFragment
import roqay.task.khrogaty.view.features.home.homeFragments.restaurants.RestaurantsFragment
import roqay.task.khrogaty.view.features.home.homeFragments.search.SearchFragment

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

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Home"
            1 -> "Search"
            2 -> "Find Places"
            3 -> "Restaurants"
            4 -> "Things To Do"
            else -> "null"
        }
    }
}