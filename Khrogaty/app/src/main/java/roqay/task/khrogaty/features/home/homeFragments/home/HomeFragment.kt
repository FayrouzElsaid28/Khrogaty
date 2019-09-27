package roqay.task.khrogaty.features.home.homeFragments.home


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*

import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.AdapterToViewCallBack
import roqay.task.khrogaty.base.extensions.makeLongToast
import roqay.task.khrogaty.base.extensions.openActivtyFromParent
import roqay.task.khrogaty.base.helpers.Resource
import roqay.task.khrogaty.features.details.DetailsActivity
import roqay.task.khrogaty.features.home.HomeViewModel
import roqay.task.khrogaty.features.home.homeFragments.Category
import roqay.task.khrogaty.features.home.homeFragments.ICategory
import roqay.task.khrogaty.features.home.homeFragments.home.Adapters.PlaceAdapter
import roqay.task.khrogaty.features.home.homeFragments.home.Adapters.RestaurantAdapter
import roqay.task.khrogaty.features.home.homeFragments.home.Adapters.ToDoAdapter

class HomeFragment : Fragment(),
    AdapterToViewCallBack,
    ICategory{

    val placesAdapter = PlaceAdapter(this,this)
    val restaurantsAadapter = RestaurantAdapter(this,this)
    val toDoAdapter = ToDoAdapter(this,this)

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initView()
    }

    private fun initView() {

        //Set horizontal layout manager
        places_for_going_out_recyclerview.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)

        restaurants_recyclerview.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)

        todo_recyclerview.layoutManager =
            LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.HORIZONTAL, false)


        places_for_going_out_recyclerview.adapter = placesAdapter
        restaurants_recyclerview.adapter = restaurantsAadapter
        todo_recyclerview.adapter = toDoAdapter

        places_for_going_out_view_more_tv.setOnClickListener {
            activity?.home_viewpager?.setCurrentItem(2)
        }
        restaurants_view_more_tv.setOnClickListener {
            activity?.home_viewpager?.setCurrentItem(3)
        }
        todo_view_more_tv.setOnClickListener {
            activity?.home_viewpager?.setCurrentItem(4)
        }
    }

    private fun initViewModel() {
        loadPlaces()
        loadRestaurants()
        loadActivities()
    }

    private fun loadActivities() {
        viewModel.getAllActivities(2)
            .observe(this, Observer {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        toDoAdapter.setData(Category.activities_list)
                        loading.visibility = View.GONE
                    }
                    Resource.Status.LOADING -> {
                        loading.visibility = View.VISIBLE
                    }
                    Resource.Status.EMPTY -> {
                        loading.visibility = View.GONE
                        makeLongToast("No activities found")
                    }
                    Resource.Status.ERROR -> {
                        loading.visibility = View.GONE
                        makeLongToast("Something went wrong")
                    }
                }
            })
    }

    private fun loadRestaurants() {
        viewModel.getAllRestaurants(3)
            .observe(this, Observer {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        restaurantsAadapter.setData(Category.restaurants_list)
                        loading.visibility = View.GONE
                    }
                    Resource.Status.LOADING -> {
                        loading.visibility = View.VISIBLE
                    }
                    Resource.Status.EMPTY -> {
                        loading.visibility = View.GONE
                        makeLongToast("No restaurants found")
                    }
                    Resource.Status.ERROR -> {
                        loading.visibility = View.GONE
                        makeLongToast("Something went wrong")
                    }
                }
            })
    }

    private fun loadPlaces() {
        viewModel.getAllPlaces(4)
            .observe(this, Observer {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        placesAdapter.setData(Category.places_list)
                        loading.visibility = View.GONE
                    }
                    Resource.Status.LOADING -> {
                        loading.visibility = View.VISIBLE
                    }
                    Resource.Status.EMPTY -> {
                        loading.visibility = View.GONE
                        makeLongToast("No places found")
                    }
                    Resource.Status.ERROR -> {
                        loading.visibility = View.GONE
                        makeLongToast("Something went wrong")
                    }
                }
            })
    }

    override fun getContext(): Context {
        return activity?.applicationContext!!
    }

    override fun openActivity() {
        openActivtyFromParent(DetailsActivity::class.java)
    }

}
