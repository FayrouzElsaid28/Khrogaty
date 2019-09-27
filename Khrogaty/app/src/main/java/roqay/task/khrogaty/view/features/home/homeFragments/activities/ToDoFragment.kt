package roqay.task.khrogaty.view.features.home.homeFragments.activities


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_to_do.*

import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.base.extensions.makeLongToast
import roqay.task.khrogaty.base.extensions.openActivtyFromParent
import roqay.task.khrogaty.view.features.details.DetailsActivity
import roqay.task.khrogaty.view.features.home.homeFragments.ICategory
import roqay.task.khrogaty.view.features.home.homeFragments.Category

class ToDoFragment : Fragment(),
    AdapterToViewCallBack,
    ICategory{

    val toDoAdapter =
        ToDoDetailsAdapter(this, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        things_to_to_recyclerview.layoutManager = LinearLayoutManager(context)
        things_to_to_recyclerview.adapter = toDoAdapter
        getActivities()

    }

    private fun getActivities() {
        when(Category.activities_list.size){
            0 -> makeLongToast("No Activities found")
            else -> toDoAdapter.setData(Category.activities_list)
        }
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

    override fun openActivity() {
        openActivtyFromParent(DetailsActivity::class.java)
    }

}
