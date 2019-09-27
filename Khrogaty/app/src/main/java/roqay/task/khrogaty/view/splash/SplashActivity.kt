package roqay.task.khrogaty.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import roqay.task.khrogaty.R
import roqay.task.khrogaty.base.extensions.openActivity
import roqay.task.khrogaty.base.helpers.LaunchingActivity
import roqay.task.khrogaty.view.features.home.HomeActivity
import roqay.task.khrogaty.view.onboarding.OnBoardingActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Check first launch
        Handler().postDelayed({
            if(isFirstLaunch())
                openActivity(this,OnBoardingActivity::class.java)
            else
                openActivity(this, HomeActivity::class.java)
            finishAffinity()
        }, 1000)
    }

    private fun isFirstLaunch() : Boolean {
        return LaunchingActivity.getInstance(applicationContext).isFirstLaunch()
    }
}
