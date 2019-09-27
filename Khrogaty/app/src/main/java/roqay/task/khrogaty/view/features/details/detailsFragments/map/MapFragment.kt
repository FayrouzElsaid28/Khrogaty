package roqay.task.khrogaty.view.features.details.detailsFragments.map


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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import roqay.task.khrogaty.base.helpers.Location


@Suppress("CAST_NEVER_SUCCEEDS")
class MapFragment : Fragment(),
    OnMapReadyCallback,
    IDetails {

    private var mMap: GoogleMap? = null
    private var currentLatLng = LatLng(Location.latitude,Location.longitude)

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
        Log.d("latlng", Location.latitude.toString()+","+Location.longitude)
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
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap

        mMap?.moveCamera(CameraUpdateFactory.newLatLng(currentLatLng))
        mMap?.animateCamera(CameraUpdateFactory.zoomTo(10f))
        mMap?.uiSettings?.isZoomControlsEnabled = true

    }

}
