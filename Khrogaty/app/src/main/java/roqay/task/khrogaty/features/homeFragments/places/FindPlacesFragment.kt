package roqay.task.khrogaty.features.homeFragments.places


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_find_places.*

import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.base.extensions.makeLongToast
import roqay.task.khrogaty.features.homeFragments.home.Category

class FindPlacesFragment : Fragment(), AdapterToViewCallBack {

    val adapter = PlacesDetailsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        find_places_recyclerview.layoutManager = LinearLayoutManager(context)
        find_places_recyclerview.adapter = adapter
        getPlaces()
    }

    private fun getPlaces() {
        when(Category.places_list.size){
            0 -> makeLongToast("No Places found")
            else -> adapter.setData(Category.places_list)
        }
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

}
