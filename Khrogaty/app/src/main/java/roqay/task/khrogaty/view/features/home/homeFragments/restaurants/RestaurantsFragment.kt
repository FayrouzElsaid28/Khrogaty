package roqay.task.khrogaty.view.features.home.homeFragments.restaurants


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_restaurants.*

import roqay.task.khrogaty.R

class RestaurantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }

    private fun setupViewPager() {
        restaurants_viewpager.adapter =
            RestaurantsPagerAdapter(
                childFragmentManager
            )
        restaurants_tablayout.setupWithViewPager(restaurants_viewpager)
    }

}
