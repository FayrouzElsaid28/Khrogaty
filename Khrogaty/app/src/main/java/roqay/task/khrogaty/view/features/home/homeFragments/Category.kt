package roqay.task.khrogaty.view.features.home.homeFragments

import roqay.task.khrogaty.view.features.home.homeFragments.search.Search
import roqay.task.khrogaty.models.activity.Activity
import roqay.task.khrogaty.models.comment.Comment
import roqay.task.khrogaty.models.place.Place
import roqay.task.khrogaty.models.restaurant.Restaurant

class Category {
    companion object{
        var places_list = arrayListOf<Place>()
        var restaurants_list = arrayListOf<Restaurant>()
        var activities_list = arrayListOf<Activity>()
        var comments_list = arrayListOf<Comment>()
        var search_list = arrayListOf<Search>()
    }
}