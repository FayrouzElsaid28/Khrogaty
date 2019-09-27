package roqay.task.khrogaty.view.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import roqay.task.khrogaty.base.helpers.Resource

class HomeViewModel: ViewModel() {

    fun getAllPlaces(categories_id: Int): LiveData<Resource<String>>{
        return HomeRepository.getAllPlaces(categories_id)
    }

    fun getAllRestaurants(categories_id: Int): LiveData<Resource<String>>{
        return HomeRepository.getAllRestaurants(categories_id)
    }

    fun getAllActivities(categories_id: Int): LiveData<Resource<String>>{
        return HomeRepository.getAllActivites(categories_id)
    }
}