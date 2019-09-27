package roqay.task.khrogaty.view.features.details.detailsFragments.map


import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_map.*
import roqay.task.khrogaty.R
import roqay.task.khrogaty.view.features.details.CategoryDetails
import roqay.task.khrogaty.view.features.details.IDetails
import android.webkit.WebViewClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.maps.*
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.model.*
import roqay.task.khrogaty.base.directionhelpers.FetchURL
import roqay.task.khrogaty.base.directionhelpers.TaskLoadedCallback
import roqay.task.khrogaty.base.extensions.getCategoryLatLng
import roqay.task.khrogaty.base.helpers.Location
import roqay.task.khrogaty.base.helpers.Location.Companion.mMap


@Suppress("CAST_NEVER_SUCCEEDS", "DEPRECATION")
class MapFragment : Fragment(),
    OnMapReadyCallback,
    IDetails,
    TaskLoadedCallback {

    private val currentLatLng = LatLng(Location.latitude,Location.longitude)
    private var categoryLatLng: LatLng? = null
    private var currentPolyline: Polyline? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDetails()
        initMap()
    }

    private fun initMap() {
        if (map != null) {
            map.onCreate(null)
            map.onResume()
            map.getMapAsync(this)
        }
    }

    override fun getDetails() {
        details_place.text = CategoryDetails.details_place
        val details_map_url = CategoryDetails.details_map_location_url
        categoryLatLng = getCategoryLatLng(details_map_url)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap

        mMap?.moveCamera(CameraUpdateFactory.newLatLng(currentLatLng))
        mMap?.animateCamera(CameraUpdateFactory.zoomTo(10f))
        mMap?.uiSettings?.isZoomControlsEnabled = true

        drawMarkers()
        drawRoute()
    }

    private fun drawMarkers() {

        //Change width and height of marker to look smaller
        val height = 50
        val width = 50
        val bitmapdraw: BitmapDrawable = resources.getDrawable(R.drawable.map_circle) as BitmapDrawable
        val b: Bitmap = bitmapdraw.bitmap
        val smallMarker = Bitmap.createScaledBitmap(b, width, height, false)

        val currentLocationMarker =  MarkerOptions().position(currentLatLng)
        val categoryMarker = MarkerOptions().position(categoryLatLng!!)

        //Set markers to this small marker
        currentLocationMarker.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        categoryMarker.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))

        //Add markers on map
        mMap?.addMarker(currentLocationMarker)
        mMap?.addMarker(categoryMarker)
    }

    private fun drawRoute() {
        val routes_url = getUrl(currentLatLng,categoryLatLng!!,"driving")
        FetchURL(context).execute(routes_url,"driving")
    }

    private fun getUrl(origin: LatLng, dest: LatLng, directionMode: String): String {
        val str_origin = "origin=" + origin.latitude + "," + origin.longitude
        val str_dest = "destination=" + dest.latitude + "," + dest.longitude
        val mode = "mode=$directionMode"
        val parameters = "$str_origin&$str_dest&$mode"
        val output = "json"
        return "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters +
                "&key=${Location.api_key}"
    }

    override fun onTaskDone(vararg values: Any) {
        currentPolyline = mMap?.addPolyline(values[0] as PolylineOptions)
    }

}
