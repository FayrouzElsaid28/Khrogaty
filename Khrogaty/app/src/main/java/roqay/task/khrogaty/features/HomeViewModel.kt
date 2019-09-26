package roqay.task.khrogaty.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import roqay.task.khrogaty.base.helpers.Resource

class HomeViewModel: ViewModel() {
    fun getAllPlaces(categories_id: Int): LiveData<Resource<String>>{
        return HomeRepository.getAllPlaces(categories_id)
    }

    fun getAllRestaurants(): LiveData<Resource<String>>{
        return HomeRepository.getAllRestaurants()
    }

    fun getAllActivities(): LiveData<Resource<String>>{
        return HomeRepository.getAllActivites()
    }
}