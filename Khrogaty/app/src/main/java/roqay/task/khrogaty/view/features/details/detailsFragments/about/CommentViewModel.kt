package roqay.task.khrogaty.view.features.details.detailsFragments.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import roqay.task.khrogaty.base.helpers.Resource
import roqay.task.khrogaty.view.features.details.DetailsRepository

class CommentViewModel: ViewModel() {
    fun getAllComments(post_id: Int): LiveData<Resource<String>> {
        return DetailsRepository.getAllComments(post_id)
    }

    fun addComment(auther_name: String,
                   author_email: String,
                   content: String,
                   post: Int): LiveData<Resource<String>> {
        return DetailsRepository.addComment(
            auther_name,
            author_email,
            content,
            post
        )
    }
}