package hermanmusic.myslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import kr.zagros.slider.banners.Banner
import kr.zagros.slider.views.BannerSlider
import kr.zagros.slider.views.indicators.IndicatorShape
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        setupBannerSlider()
    }

    private fun setupBannerSlider() {
        BannerSlider.init(viewHolderBanner())
        val bannerSlider = findViewById<BannerSlider>(R.id.slider)
        bannerSlider.setBannerLayout(R.layout.banner_layout)


        val bannerModels = ArrayList<Banner>()
        for (s in slides) {
            val r = Random
            val b = r.nextBoolean()
            val bannerModel = BannerModel(s, b, "artist ", " title of song")
            bannerModels.add(bannerModel)
        }
        bannerSlider.setLoopSlides(false)
        bannerSlider.setDefaultIndicator(IndicatorShape.DASH)
        bannerSlider.setBanners(bannerModels)
    }

    companion object {
        var slides = arrayOf(
                "https://images.unsplash.com/photo-1458724338480-79bc7a8352e4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
                "https://images.unsplash.com/photo-1461770354136-8f58567b617a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
                "https://images.unsplash.com/photo-1493087670264-2f7f5844b402?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
                "https://images.unsplash.com/photo-1500514966906-fe245eea9344?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60")
    }
}