package kr.zagros.slider.views.indicators;


import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.LinearLayout;

import kr.zagros.shwan.slider.R;


public class DashIndicator extends IndicatorShape {

    public DashIndicator(Context context, int indicatorSize, boolean mustAnimateChanges) {
        super(context, indicatorSize, mustAnimateChanges);
        setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.indicator_dash_unselected, null));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = getResources().getDimensionPixelSize(R.dimen.default_dash_indicator_width);
            setLayoutParams(layoutParams);
        }
    }

    @Override
    public void onCheckedChange(boolean isChecked) {
        super.onCheckedChange(isChecked);
        if (isChecked) {
            setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.indicator_dash_selected, null));
        } else {
            setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.indicator_dash_unselected, null));
        }
    }
}

