package kr.zagros.slider.events;

public interface IAttributeChange {
    void onIndicatorSizeChange();
    void onSelectedSlideIndicatorChange();
    void onUnselectedSlideIndicatorChange();
    void onDefaultIndicatorsChange();
    void onAnimateIndicatorsChange();
    void onIntervalChange();
    void onLoopSlidesChange();
    void onDefaultBannerChange();
    void onEmptyViewChange();
    void onHideIndicatorsValueChanged();
}