package roqay.task.khrogaty.api

var places = 4
var activities = 2
var restaurants = 3
var auther_name = ""
var author_email = ""
var content = ""
var post = -1

val BASE_URL = " http://reactnative.website/iti/wp-json/wp/v2/"
val PLACES_URL = BASE_URL + "posts?categories=$places"
val ACTIVITIES_URL = BASE_URL + "posts?categories=$activities"
val RESTAURANTS_URL = BASE_URL + "posts?categories=$restaurants"
val COMMENTS_URL = BASE_URL + "comments?post=$post"
val ADD_COMMENT_URL = BASE_URL + "comments?author_name=$auther_name" +
        "&author_email=$author_email" +
        "&content=$content" +
        "&post=$post"