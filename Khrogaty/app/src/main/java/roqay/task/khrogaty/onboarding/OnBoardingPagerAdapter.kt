package roqay.task.khrogaty.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import roqay.task.khrogaty.BlankFragment
import roqay.task.khrogaty.onboarding.onBoardingFragments.FirstOnBoardingFragment
import roqay.task.khrogaty.onboarding.onBoardingFragments.SecondOnBoardingFragment
import roqay.task.khrogaty.onboarding.onBoardingFragments.ThirdOnBoardingFragment

@Suppress("DEPRECATION")
class OnBoardingPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstOnBoardingFragment()
            1 -> SecondOnBoardingFragment()
            2 -> ThirdOnBoardingFragment()
            else -> BlankFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}