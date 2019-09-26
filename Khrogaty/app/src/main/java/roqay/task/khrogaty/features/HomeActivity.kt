package roqay.task.khrogaty.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_home.*
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.INavigation

class HomeActivity : AppCompatActivity(), INavigation {

    private var currentFragment = 0
    private var selectedColor = 0
    private var unselectedColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        home_viewpager.adapter = HomePagerAdapter(supportFragmentManager)
        handleNavigation()
        handleViewPager()
    }

    override fun handleNavigation() {

        selectedColor = ContextCompat.getColor(applicationContext,R.color.nav_green)
        unselectedColor = ContextCompat.getColor(applicationContext,R.color.nav_gray)

        home.setOnClickListener {
            currentFragment = 0
            home_viewpager.setCurrentItem(currentFragment,true)
        }
        search.setOnClickListener {
            currentFragment = 1
            home_viewpager.setCurrentItem(currentFragment,true)
        }
        find_places.setOnClickListener {
            currentFragment = 2
            home_viewpager.setCurrentItem(currentFragment,true)
        }
        restaurants.setOnClickListener {
            currentFragment = 3
            home_viewpager.setCurrentItem(currentFragment,true)
        }
        things_to_to.setOnClickListener {
            currentFragment = 4
            home_viewpager.setCurrentItem(currentFragment,true)
        }
    }

    override fun handleViewPager() {
        home_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                currentFragment = position
                handleNavView(currentFragment)
            }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    override fun handleNavView(id: Int) {
        when(id){
            0 -> {
                // Home fragment is selected
                home_img.setImageResource(R.drawable.ghome)
                home_tv.setTextColor(selectedColor)

                search_img.setImageResource(R.drawable.filter)
                find_places_img.setImageResource(R.drawable.find_places)
                restaurants_img.setImageResource(R.drawable.restaurants)
                things_to_to_img.setImageResource(R.drawable.todo)

                search_tv.setTextColor(unselectedColor)
                find_places_tv.setTextColor(unselectedColor)
                restaurants_tv.setTextColor(unselectedColor)
                things_to_to_tv.setTextColor(unselectedColor)
            }
            1 -> {
                //Search fragment is selected
                search_img.setImageResource(R.drawable.gfilter)
                search_tv.setTextColor(selectedColor)

                home_img.setImageResource(R.drawable.home)
                find_places_img.setImageResource(R.drawable.find_places)
                restaurants_img.setImageResource(R.drawable.restaurants)
                things_to_to_img.setImageResource(R.drawable.todo)

                home_tv.setTextColor(unselectedColor)
                find_places_tv.setTextColor(unselectedColor)
                restaurants_tv.setTextColor(unselectedColor)
                things_to_to_tv.setTextColor(unselectedColor)
            }
            2 -> {
                //Find places fragment is selected
                find_places_img.setImageResource(R.drawable.gfind_places)
                find_places_tv.setTextColor(selectedColor)

                home_img.setImageResource(R.drawable.home)
                search_img.setImageResource(R.drawable.filter)
                restaurants_img.setImageResource(R.drawable.restaurants)
                things_to_to_img.setImageResource(R.drawable.todo)

                home_tv.setTextColor(unselectedColor)
                search_tv.setTextColor(unselectedColor)
                restaurants_tv.setTextColor(unselectedColor)
                things_to_to_tv.setTextColor(unselectedColor)
            }
            3 -> {
                //Restaurants fragment is selected
                restaurants_img.setImageResource(R.drawable.grestaurants)
                restaurants_tv.setTextColor(selectedColor)

                home_img.setImageResource(R.drawable.home)
                search_img.setImageResource(R.drawable.filter)
                find_places_img.setImageResource(R.drawable.find_places)
                things_to_to_img.setImageResource(R.drawable.todo)

                home_tv.setTextColor(unselectedColor)
                search_tv.setTextColor(unselectedColor)
                find_places_tv.setTextColor(unselectedColor)
                things_to_to_tv.setTextColor(unselectedColor)
            }
            4 -> {
                //To Do fragment is selected
                things_to_to_img.setImageResource(R.drawable.gtodo)
                things_to_to_tv.setTextColor(selectedColor)

                home_img.setImageResource(R.drawable.home)
                search_img.setImageResource(R.drawable.filter)
                restaurants_img.setImageResource(R.drawable.restaurants)
                find_places_img.setImageResource(R.drawable.find_places)

                home_tv.setTextColor(unselectedColor)
                search_tv.setTextColor(unselectedColor)
                restaurants_tv.setTextColor(unselectedColor)
                find_places_tv.setTextColor(unselectedColor)
            }
        }
    }
}
