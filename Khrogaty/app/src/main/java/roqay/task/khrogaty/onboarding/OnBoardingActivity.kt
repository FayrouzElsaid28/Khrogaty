package roqay.task.khrogaty.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_on_boarding.*
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.extensions.openActivity
import roqay.task.khrogaty.base.helpers.LaunchingActivity
import roqay.task.khrogaty.features.HomeActivity

class OnBoardingActivity : AppCompatActivity() {

    private var currentFragment = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        /*
        Application is opened -- disable first launch
         */
        LaunchingActivity.getInstance(applicationContext).setIsFirstLaunchToFalse()
        onboarding_viewpager.adapter = OnBoardingPagerAdapter(supportFragmentManager)
        handleViewPager()
        handleNavigation()

    }

    private fun handleNavigation() {
        next_tv.setOnClickListener {
            currentFragment ++
            onboarding_viewpager.setCurrentItem(currentFragment, true)
        }
        prev_tv.setOnClickListener {
            currentFragment --
            onboarding_viewpager.setCurrentItem(currentFragment, true)
        }
        start_tv.setOnClickListener {
            openActivity(this,HomeActivity::class.java)
            finishAffinity()
        }
    }

    private fun handleViewPager() {
        onboarding_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                currentFragment = position
                checkCurrentFragment()
            }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    private fun checkCurrentFragment() {
        if (currentFragment == 0){
            prev_tv.visibility = View.GONE
            start_tv.visibility = View.GONE
            next_tv.visibility = View.VISIBLE
        }
        else if (currentFragment == 1){
            prev_tv.visibility = View.VISIBLE
            start_tv.visibility = View.GONE
            next_tv.visibility = View.VISIBLE
        }else{
            prev_tv.visibility = View.VISIBLE
            start_tv.visibility = View.VISIBLE
            next_tv.visibility = View.GONE
        }
    }
}
