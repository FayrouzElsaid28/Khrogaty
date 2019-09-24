package roqay.task.khrogaty.base.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast

private const val PREFERENCE_NAME = "roqay.khrogaty"

fun <T> Activity.openActivity(context: Context, cls: Class<T>) {
    startActivity(Intent(context, cls))
}

fun <T> Activity.openActivityClearStack(context: Context, cls: Class<T>) {
    startActivity(Intent(context, cls).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
}

fun Activity.makeLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.disableCheck(layout: LinearLayout , length: Int){
    for (i in 0 until length){
        (layout.getChildAt(i)as CheckBox).isChecked = false
        (layout.getChildAt(i)as CheckBox).isEnabled = true
    }
}

fun Activity.getSharedPreferences(): SharedPreferences =
    getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
