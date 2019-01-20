package kr.zagros.slider.views.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.zagros.shwan.slider.R;
import kr.zagros.slider.GlideApp;
import kr.zagros.slider.banners.Banner;
import kr.zagros.slider.banners.DrawableBanner;
import kr.zagros.slider.banners.RemoteBanner;
import kr.zagros.slider.events.OnBannerClickListener;


public class BannerFragment extends Fragment {
    private Banner banner;

    public BannerFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        banner = getArguments().getParcelable("banner");
    }

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (banner != null) {
            View view = inflater.inflate(R.layout.banner_layout, container, false);
            ImageView imageView=view.findViewById(R.id.image_banner);
            if (banner instanceof DrawableBanner) {
                DrawableBanner drawableBanner = (DrawableBanner) banner;
                GlideApp.with(getContext()).load(drawableBanner.getDrawable()).into(imageView);
            } else {
                final RemoteBanner remoteBanner = (RemoteBanner) banner;
                if (remoteBanner.getErrorDrawable() == null && remoteBanner.getPlaceHolder() == null) {
                    GlideApp.with(getContext()).load(remoteBanner.getUrl()).into(imageView);
                }
            }
            imageView.setOnTouchListener(banner.getOnTouchListener());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OnBannerClickListener onBannerClickListener = banner.getOnBannerClickListener();
                    if (onBannerClickListener != null) {
                        onBannerClickListener.onClick(banner.getPosition());
                    }
                }
            });

            return view;
        } else {
            throw new RuntimeException("banner cannot be null");
        }
    }

    public static BannerFragment newInstance(Banner banner) {
        Bundle args = new Bundle();
        args.putParcelable("banner", banner);
        BannerFragment fragment = new BannerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
