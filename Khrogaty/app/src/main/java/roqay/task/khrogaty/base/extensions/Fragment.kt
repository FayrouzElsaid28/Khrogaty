package roqay.task.khrogaty.base.extensions

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.fragment.app.Fragment

fun <T> Fragment.openActivtyFromParent(cls: Class<T>) {
    activity?.openActivity(activity!!, cls)
}

fun Fragment.makeLongToast(message: String) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}
