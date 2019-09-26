package roqay.task.khrogaty.api

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest
import com.androidnetworking.common.Priority

object HomeFactory {

    fun getAllPlaces(categories_id: Int): ANRequest<*>{
        val androidNetworking = AndroidNetworking.get(PLACES_URL)
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }

    fun getAllRestaurants(): ANRequest<*>{
        val androidNetworking = AndroidNetworking.get(RESTAURANTS_URL)
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }

    fun getAllActivites(): ANRequest<*>{
        val androidNetworking = AndroidNetworking.get(ACTIVITIES_URL)
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }


}