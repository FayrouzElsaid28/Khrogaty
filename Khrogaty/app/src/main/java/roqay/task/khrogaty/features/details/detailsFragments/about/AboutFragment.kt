package roqay.task.khrogaty.features.details.detailsFragments.about


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_about.*

import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.extensions.makeLongToast
import roqay.task.khrogaty.base.helpers.Resource
import roqay.task.khrogaty.features.details.CategoryDetails
import roqay.task.khrogaty.features.details.IDetails
import roqay.task.khrogaty.features.home.homeFragments.Category

class AboutFragment : Fragment(), IDetails {

    val commentAdapter = CommentAdapter()

    private val viewModel: CommentViewModel by lazy {
        ViewModelProviders.of(this).get(CommentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        getDetails()
    }

    private fun initView() {
        comments_recyclerview.layoutManager = LinearLayoutManager(context)
        comments_recyclerview.adapter = commentAdapter

        send_comment_img.setOnClickListener {
            sendComment()
        }
    }

    private fun sendComment() {
        if (add_comment_et.text.trim().length > 0){
            viewModel.addComment("Fayrouz",
                "Fayrouzelsaid28@gmail.com",
                add_comment_et.text.toString(),
                CategoryDetails.post_id)
                .observe(this, Observer {
                    when(it.status){
                        Resource.Status.SUCCESS -> {
                            makeLongToast("Comment added successfully")
                            commentAdapter.notifyDataSetChanged()
                            add_comment_et.setText("")
                            loading.visibility = View.GONE
                        }
                        Resource.Status.LOADING -> {
                            loading.visibility = View.VISIBLE
                        }
                        Resource.Status.EMPTY -> {
                            makeLongToast(it.message!!)
                            loading.visibility = View.GONE
                        }
                        Resource.Status.ERROR -> {
                            makeLongToast(it?.message!!)
                            Log.d("error",it.message!!)
                            loading.visibility = View.GONE
                        }
                    }
                })

        }else{
            makeLongToast("Please type something")
        }
    }

    override fun getDetails() {
        val image_url = CategoryDetails.details_img_url
        Picasso.with(context).load(image_url).into(details_img)
        details_name.text = CategoryDetails.details_name
        details_info.text = CategoryDetails.details_information
        details_place.text = CategoryDetails.details_place
        details_phone.text = CategoryDetails.details_phone
        details_mail.text = CategoryDetails.details_email
        loadComments(CategoryDetails.post_id)
    }

    private fun loadComments(postId: Int) {
        viewModel.getAllComments(postId)
            .observe(this, Observer {
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        commentAdapter.setData(Category.comments_list)
                        loading.visibility = View.GONE
                    }
                    Resource.Status.LOADING -> {
                        loading.visibility = View.VISIBLE
                    }
                    Resource.Status.EMPTY -> {
                        makeLongToast("No comments found")
                        loading.visibility = View.GONE
                    }
                    Resource.Status.ERROR -> {
                        loading.visibility = View.GONE
                        makeLongToast("Something went wrong")
                        Log.d("Error", it.message)
                    }

                }
            })
    }

}
