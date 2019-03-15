package kr.zagros.slider.views.custom;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.Collections;
import java.util.List;

import kr.zagros.slider.banners.Banner;
import kr.zagros.slider.views.BannerSlider;


public class BannerAdapter extends PagerAdapter {
    private List<Banner> banners;
    private Context mContext;


    private int bannerLayout;
    private boolean isLooping;

    @LayoutRes
    private int emptyView;

    public BannerAdapter(boolean isLooping, List<Banner> banners, Context context, int bannerLayout) {
        this.isLooping = isLooping;
        this.banners = banners;
        this.mContext = context;
        this.bannerLayout = bannerLayout;
    }

    public BannerAdapter(boolean isLooping, int layoutDirection, List<Banner> banners, Context context, int bannerLayout) {
        this.isLooping = isLooping;
        this.banners = banners;
        this.mContext = context;
        this.bannerLayout = bannerLayout;
        if (layoutDirection == LayoutDirection.RTL) {
            Collections.reverse(banners);
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public int getCount() {
        if (banners.isEmpty()) {
            if (emptyView > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (isLooping) {
            return banners.size() + 2;
        } else {
            return banners.size();
        }
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        Banner banner;
        if (banners.isEmpty() && emptyView > 0) {
            //banner = new Banner();
        }
        if (isLooping) {
            if (position == 0) {
                banner = banners.get(banners.size() - 1);
            } else if (position == banners.size() + 1) {
                banner = banners.get(0);
            } else {
                banner = banners.get(position - 1);
            }
        } else {
            banner = banners.get(position);
        }
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(bannerLayout, collection, false);
        BannerSlider.getImageLoadingService().onBindView(layout, banner);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    public void setEmptyView(int emptyView) {
        this.emptyView = emptyView;
        notifyDataSetChanged();
    }
}
