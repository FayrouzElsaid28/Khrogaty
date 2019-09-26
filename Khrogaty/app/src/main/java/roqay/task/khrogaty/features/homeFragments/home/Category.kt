package roqay.task.khrogaty.features.homeFragments.home

import roqay.task.khrogaty.models.activity.Activity
import roqay.task.khrogaty.models.place.Place
import roqay.task.khrogaty.models.restaurant.Restaurant

class Category {
    companion object{
        var places_list = arrayListOf<Place>()
        var restaurants_list = arrayListOf<Restaurant>()
        var activities_list = arrayListOf<Activity>()
    }
}