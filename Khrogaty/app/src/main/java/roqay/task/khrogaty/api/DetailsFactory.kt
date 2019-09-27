package roqay.task.khrogaty.api

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest
import com.androidnetworking.common.Priority

object DetailsFactory {

    fun getAllComments(post_id: Int): ANRequest<*> {
        val androidNetworking = AndroidNetworking.get(Url_helper.getCommentsUrl(post_id))
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }

    fun addComment(auther_name: String, author_email: String, content: String, post: Int): ANRequest<*>{
        val androidNetworking = AndroidNetworking.post(Url_helper.getAddCommentUrl(
            auther_name, author_email, content, post
        ))
            .setPriority(Priority.MEDIUM)
            .build()

        return androidNetworking
    }
}