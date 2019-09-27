package roqay.task.khrogaty.features.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import roqay.task.khrogaty.BlankFragment
import roqay.task.khrogaty.features.details.detailsFragments.about.AboutFragment
import roqay.task.khrogaty.features.details.detailsFragments.map.MapFragment

@Suppress("DEPRECATION")
class DetailsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AboutFragment()
            1 -> MapFragment()
            else -> BlankFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "About"
            1 -> "Map"
            else -> "null"
        }
    }
}