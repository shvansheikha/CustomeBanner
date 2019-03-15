package hermanmusic.myslider

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kr.zagros.slider.events.BannerLoadingService


class viewHolderBanner : BannerLoadingService {
    override fun onBindView(view: View, data: Any) {

        if (data is BannerModel) {
            val imageView = view.findViewById<ImageView>(R.id.image_banner)
            val typeOfBanner = view.findViewById<TextView>(R.id.typeOfBanner)
            val titleOfBanner = view.findViewById<TextView>(R.id.titleOfBanner)
            val artist = view.findViewById<TextView>(R.id.artist)

            Picasso.get().load(data.imageUrl).into(imageView)

            if (data.typeBanner!!) typeOfBanner.text="single" else typeOfBanner.text="album"

            titleOfBanner.text = data.title
            artist.text = data.artist
        }


    }
}
