package roqay.task.khrogaty.features.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_details.*
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.INavigation
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.custom_tab.view.*


class DetailsActivity : AppCompatActivity(),
    IDetails, INavigation {

    private var currentFragment = 0
    private var firstTab: ConstraintLayout? = null
    private var secondTab: ConstraintLayout? = null
    private var selectedColor = 0
    private var unselectedColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initView()
    }

    private fun initView() {
        details_viewpager.adapter = DetailsPagerAdapter(supportFragmentManager)
        details_back.setOnClickListener { onBackPressed() }

        details_tablayout.setupWithViewPager(details_viewpager)
        handleViewPager()
        handleTabLayout()
        getDetails()
    }

    private fun handleTabLayout() {
        firstTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ConstraintLayout
        secondTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ConstraintLayout

        firstTab?.tab_txt?.text = "About"
        secondTab?.tab_txt?.text = "Map"

        details_tablayout.getTabAt(0)?.customView = firstTab
        details_tablayout.getTabAt(1)?.customView = secondTab

        selectedColor = ContextCompat.getColor(applicationContext,R.color.black)
        unselectedColor = ContextCompat.getColor(applicationContext,R.color.nav_gray)
    }

    override fun handleViewPager() {
        details_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
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
                firstTab?.tab_img?.setImageResource(R.drawable.gabout)
                firstTab?.tab_txt?.setTextColor(selectedColor)

                secondTab?.tab_img?.setImageResource(R.drawable.grey_map_marker)
                secondTab?.tab_txt?.setTextColor(unselectedColor)
            }
            1 -> {
                firstTab?.tab_img?.setImageResource(R.drawable.about)
                firstTab?.tab_txt?.setTextColor(unselectedColor)

                secondTab?.tab_img?.setImageResource(R.drawable.map_marker)
                secondTab?.tab_txt?.setTextColor(selectedColor)
            }
        }
    }

    override fun getDetails() {
        details_name.text = CategoryDetails.details_name
    }
}
