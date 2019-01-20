package hermanmusic.myslider.banner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hermanmusic.myslider.R;
import kr.zagros.slider.banners.Banner;
import kr.zagros.slider.banners.RemoteBanner;
import kr.zagros.slider.events.OnBannerClickListener;
import kr.zagros.slider.views.BannerSlider;
import kr.zagros.slider.views.indicators.IndicatorShape;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BannerSlider bannerSlider=findViewById(R.id.banner);

        final List<Banner> bannerList=new ArrayList<>();
        bannerList.add(new RemoteBanner("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg"));
        bannerList.add(new RemoteBanner("https://assets.materialup.com/uploads/61a28c4a-7713-41b4-ad59-6fe071f3556a/attachment.png"));
        bannerList.add(new RemoteBanner("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg"));
        bannerList.add(new RemoteBanner("https://assets.materialup.com/uploads/549fdb83-4929-4e0e-bf03-a23302c4fa4a/teaser.png"));
        bannerList.add(new RemoteBanner("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png"));
        bannerSlider.setBanners(bannerList);
        bannerSlider.setLoopSlides(false);
        bannerSlider.setDefaultIndicator(IndicatorShape.DASH);
       //bannerSlider.setIndicatorSize(R.dimen.margin_top_list_item);
        bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(Main2Activity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
