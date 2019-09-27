package roqay.task.khrogaty.view.features.details

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_details.*
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.INavigation
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.android.synthetic.main.custom_tab.view.*
import roqay.task.khrogaty.base.directionhelpers.TaskLoadedCallback
import roqay.task.khrogaty.base.helpers.Location


@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity(),
    IDetails,
    INavigation,
    TaskLoadedCallback {

    private var currentFragment = 0
    private var firstTab: ConstraintLayout? = null
    private var secondTab: ConstraintLayout? = null
    private var selectedColor = 0
    private var unselectedColor = 0
    private var locationManager: LocationManager? = null
    private var currentPolyline: Polyline? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initView()
    }

    private fun initView() {
        details_viewpager.adapter = DetailsPagerAdapter(supportFragmentManager)
        details_back.setOnClickListener { onBackPressed() }

        details_tablayout.setupWithViewPager(details_viewpager)
        handleViewPager()
        handleTabLayout()
        getDetails()
        getCurrentLocation()
    }

    private fun handleTabLayout() {
        //Set tabs back round to custom tab so that image can be at the right if text
        firstTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ConstraintLayout
        secondTab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null) as ConstraintLayout

        firstTab?.tab_txt?.text = "About"
        secondTab?.tab_txt?.text = "Map"

        details_tablayout.getTabAt(0)?.customView = firstTab
        details_tablayout.getTabAt(1)?.customView = secondTab

        selectedColor = ContextCompat.getColor(applicationContext,R.color.black)
        unselectedColor = ContextCompat.getColor(applicationContext,R.color.nav_gray)
    }

    override fun handleViewPager() {
        details_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                currentFragment = position
                handleNavView(currentFragment)
            }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    override fun handleNavView(id: Int) {
        when(id){
            0 -> {
                firstTab?.tab_img?.setImageResource(R.drawable.gabout)
                firstTab?.tab_txt?.setTextColor(selectedColor)

                secondTab?.tab_img?.setImageResource(R.drawable.grey_map_marker)
                secondTab?.tab_txt?.setTextColor(unselectedColor)
            }
            1 -> {
                firstTab?.tab_img?.setImageResource(R.drawable.about)
                firstTab?.tab_txt?.setTextColor(unselectedColor)

                secondTab?.tab_img?.setImageResource(R.drawable.map_marker)
                secondTab?.tab_txt?.setTextColor(selectedColor)
            }
        }
    }

    private fun getCurrentLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        if (!locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER)!!) {
            buildAlertMessageNoGps()

        } else if (locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            setLocationData()
        }
    }

    private fun setLocationData() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
            )

        } else {
            val location = locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            val location1 = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            val location2 = locationManager?.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)

            if (location != null) {
                Location.latitude = location.latitude
                Location.longitude = location.longitude
            } else if (location1 != null) {
                Location.latitude = location1.latitude
                Location.longitude = location1.longitude
            } else if (location2 != null) {
                Location.latitude = location2.latitude
                Location.longitude = location2.longitude
            } else {
                Toast.makeText(this, "Unable to trace your location", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun buildAlertMessageNoGps() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Please Turn ON your GPS Connection")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                setLocationData()
            }
            .setNegativeButton("No", null)
            .create()
            .show()
    }

    override fun getDetails() {
        details_name.text = CategoryDetails.details_name
    }

    override fun onTaskDone(vararg values: Any?) {
        currentPolyline = Location.mMap?.addPolyline(values[0] as PolylineOptions)
    }
}
