package roqay.task.khrogaty.base.helpers

import com.google.android.gms.maps.GoogleMap

/**
 * Values needed for current location and routing
 */
class Location {
    companion object{
        var latitude = 0.0
        var longitude = 0.0
        val api_key = "AIzaSyA1eUIea28DgP3Jw4Y5cpcU9D4v6E22A-c"
        var mMap: GoogleMap? = null
        var lineColor: Int = -1
    }
}