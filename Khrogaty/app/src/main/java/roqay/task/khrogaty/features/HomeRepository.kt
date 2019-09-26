package roqay.task.khrogaty.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import roqay.task.khrogaty.api.HomeFactory
import roqay.task.khrogaty.base.helpers.Resource
import roqay.task.khrogaty.features.homeFragments.home.Category
import roqay.task.khrogaty.models.activity.Activity
import roqay.task.khrogaty.models.place.Place
import roqay.task.khrogaty.models.restaurant.Restaurant

object HomeRepository {
    fun getAllPlaces(categories_id: Int): LiveData<Resource<String>>{
        val data = MutableLiveData<Resource<String>>()
        data.value = Resource.loading()

        HomeFactory.getAllPlaces(categories_id).getAsObjectList(Place::class.java,
            object : ParsedRequestListener<ArrayList<Place>> {
                override fun onResponse(response: ArrayList<Place>?) {
                    if (response?.size!! > 0) {
                        Category.places_list = response
                        data.postValue(Resource.success(""))
                    }
                    else
                        data.postValue(Resource.empty("",""))
                }

                override fun onError(anError: ANError?) {
                    data.postValue(Resource.error(anError?.message))
                }

            })

        return data
    }

    fun getAllRestaurants(): LiveData<Resource<String>>{
        val data = MutableLiveData<Resource<String>>()
        data.value = Resource.loading()

        HomeFactory.getAllRestaurants().getAsObjectList(Restaurant::class.java,
            object : ParsedRequestListener<ArrayList<Restaurant>> {
                override fun onResponse(response: ArrayList<Restaurant>?) {
                    if (response?.size!! > 0) {
                        Category.restaurants_list = response
                        data.postValue(Resource.success(""))
                    }
                    else
                        data.postValue(Resource.empty("",""))
                }

                override fun onError(anError: ANError?) {
                    data.postValue(Resource.error(anError?.message))
                }

            })

        return data
    }

    fun getAllActivites(): LiveData<Resource<String>>{
        val data = MutableLiveData<Resource<String>>()
        data.value = Resource.loading()

        HomeFactory.getAllRestaurants().getAsObjectList(Activity::class.java,
            object : ParsedRequestListener<ArrayList<Activity>> {
                override fun onResponse(response: ArrayList<Activity>?) {
                    if (response?.size!! > 0) {
                        Category.activities_list = response
                        data.postValue(Resource.success(""))
                    }
                    else
                        data.postValue(Resource.empty("",""))
                }

                override fun onError(anError: ANError?) {
                    data.postValue(Resource.error(anError?.message))
                }

            })

        return data
    }
}