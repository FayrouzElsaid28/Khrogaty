package roqay.task.khrogaty.features.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import roqay.task.khrogaty.api.DetailsFactory
import roqay.task.khrogaty.base.helpers.Resource
import roqay.task.khrogaty.features.home.homeFragments.Category
import roqay.task.khrogaty.models.comment.Comment

object DetailsRepository {
    fun getAllComments(post_id: Int): LiveData<Resource<String>> {
        val data = MutableLiveData<Resource<String>>()
        data.value = Resource.loading()

        DetailsFactory.getAllComments(post_id).getAsObjectList(Comment::class.java,
            object : ParsedRequestListener<ArrayList<Comment>> {
                override fun onResponse(response: ArrayList<Comment>?) {
                    if (response?.size!! > 0) {
                        Category.comments_list = response
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

    fun addComment(auther_name: String,
                   author_email: String,
                   content: String,
                   post: Int): LiveData<Resource<String>> {
        val data = MutableLiveData<Resource<String>>()
        data.value = Resource.loading()

        DetailsFactory.addComment(
            auther_name, author_email, content, post
        ).getAsObject(Comment::class.java,
            object : ParsedRequestListener<Comment> {
                override fun onResponse(response: Comment?) {
                    if (response != null) {
                        Category.comments_list.add(response!!)
                        data.postValue(Resource.success(""))
                    }
                    else
                        data.postValue(Resource.empty("","You have already said that"))
                }

                override fun onError(anError: ANError?) {
                    data.postValue(Resource.error("Something went wrong"))
                }

            })

        return data
    }
}