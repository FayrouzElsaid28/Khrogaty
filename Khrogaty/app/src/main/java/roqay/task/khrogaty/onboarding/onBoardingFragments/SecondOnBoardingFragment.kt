package roqay.task.khrogaty.onboarding.onBoardingFragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import roqay.task.khrogaty.R

/**
 * A simple [Fragment] subclass.
 */
class SecondOnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_on_boarding, container, false)
    }


}
