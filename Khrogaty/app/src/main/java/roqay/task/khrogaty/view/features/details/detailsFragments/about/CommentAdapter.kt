package roqay.task.khrogaty.view.features.details.detailsFragments.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import roqay.task.khrogaty.R
import roqay.task.khrogaty.models.comment.Comment

class CommentAdapter:
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    var comments_list = ArrayList<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_comment,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return comments_list.size
    }

    fun setData(newData: ArrayList<Comment>){
        comments_list = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.auther_name.text = comments_list[position].author_name
        holder.comment_date.text = comments_list[position].date
        holder.comment_info.text = comments_list[position].content.rendered
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var auther_name = itemView.findViewById<TextView>(R.id.auther_name)
        var comment_date = itemView.findViewById<TextView>(R.id.comment_date)
        var comment_info = itemView.findViewById<TextView>(R.id.comment_info)
    }
}