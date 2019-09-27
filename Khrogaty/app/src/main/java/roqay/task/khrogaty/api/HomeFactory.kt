package roqay.task.khrogaty.api

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest
import com.androidnetworking.common.Priority

object HomeFactory {

    fun getAllPlaces(categories_id: Int): ANRequest<*>{
        val androidNetworking = AndroidNetworking.get(Url_helper.getPlacesUrl(categories_id))
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }

    fun getAllRestaurants(categories_id: Int): ANRequest<*>{
        val androidNetworking = AndroidNetworking.get(Url_helper.getRestaurantsUrl(categories_id))
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }

    fun getAllActivites(categories_id: Int): ANRequest<*>{
        val androidNetworking = AndroidNetworking.get(Url_helper.getActivitesUrl(categories_id))
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }


}