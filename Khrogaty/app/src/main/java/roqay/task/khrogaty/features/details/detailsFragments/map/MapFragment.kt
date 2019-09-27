package roqay.task.khrogaty.features.details.detailsFragments.map


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_map.*
import roqay.task.khrogaty.R
import roqay.task.khrogaty.features.details.CategoryDetails
import roqay.task.khrogaty.features.details.IDetails
import android.webkit.WebViewClient
import android.content.Intent
import android.net.Uri
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback


class MapFragment : Fragment(),
    OnMapReadyCallback,
    IDetails {

    private var mMap: GoogleMap? = null

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
    }

    override fun getDetails() {
        details_place.text = CategoryDetails.details_place
        val details_map_url = CategoryDetails.details_map_location_url
    }

    private fun initWebView(detailsMapUrl: String) {
        map_webview.webViewClient = WebViewClient()
        map_webview.settings.javaScriptEnabled = true
        map_webview.loadUrl(detailsMapUrl)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
    }

}
