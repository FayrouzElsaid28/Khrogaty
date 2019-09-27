package roqay.task.khrogaty.api

object Url_helper {

    val BASE_URL = " http://reactnative.website/iti/wp-json/wp/v2/"

    fun getPlacesUrl(places: Int): String{
        val PLACES_URL = BASE_URL + "posts?categories=$places"
        return PLACES_URL
    }

    fun getActivitesUrl(activities: Int): String{
        val ACTIVITIES_URL = BASE_URL + "posts?categories=$activities"
        return ACTIVITIES_URL
    }

    fun getRestaurantsUrl(restaurants: Int): String{
        val RESTAURANTS_URL = BASE_URL + "posts?categories=$restaurants"
        return RESTAURANTS_URL
    }

    fun getCommentsUrl(id: Int): String{
        val COMMENTS_URL = BASE_URL + "comments?post=$id"
        return COMMENTS_URL
    }

    fun getAddCommentUrl(auther_name: String, author_email: String, content: String, post: Int): String{
        val ADD_COMMENT_URL = BASE_URL + "comments?author_name=$auther_name" +
                "&author_email=$author_email" +
                "&content=$content" +
                "&post=$post"
        return ADD_COMMENT_URL
    }
}