package kr.zagros.slider.banners;


import android.graphics.drawable.Drawable;

public class RemoteBanner extends Banner {
    private String url;
    private boolean isTrack;
    private String title;
    private String Artists;

    private Drawable placeHolder;
    private Drawable errorDrawable;

    public RemoteBanner(String url, boolean isTrack, String title, String artists) {
        this.url = url;
        this.isTrack = isTrack;
        this.title = title;
        this.Artists = artists;
    }

    public boolean isTrack() {
        return isTrack;
    }

    public String getTitle() {
        return title;
    }

    public String getArtists() {
        return Artists;
    }

    public String getUrl() {
        return url;
    }

    public Drawable getPlaceHolder() {
        return placeHolder;
    }

    public RemoteBanner setPlaceHolder(Drawable placeHolder) {
        this.placeHolder = placeHolder;
        return this;
    }

    public Drawable getErrorDrawable() {
        return errorDrawable;
    }

    public RemoteBanner setErrorDrawable(Drawable errorDrawable) {
        this.errorDrawable = errorDrawable;
        return this;
    }


    @Override
    public int describeContents() {
        return 0;
    }


}
