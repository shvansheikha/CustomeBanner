package hermanmusic.myslider.bottom;


import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.support.v4.app.Fragment;

import hermanmusic.myslider.R;
import hermanmusic.myslider.bottom.fragment.CartFragment;
import hermanmusic.myslider.bottom.fragment.GiftsFragment;
import hermanmusic.myslider.bottom.fragment.ProfileFragment;
import hermanmusic.myslider.bottom.fragment.StoreFragment;

public class BottomActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_mainFragments_home:
                    insertBadge(0);
                    changeIcon(0);
                    fragment = new StoreFragment();
                    loadFragment(fragment);
                    break;
                case R.id.action_mainFragments_news:
                    insertBadge(1);
                    changeIcon(1);
                    fragment = new GiftsFragment();
                    loadFragment(fragment);
                    break;
                case R.id.action_mainFragments_support:
                    insertBadge(2);
                    changeIcon(2);
                    fragment = new CartFragment();
                    loadFragment(fragment);
                    break;
                case R.id.action_mainFragments_profile:
                    insertBadge(3);
                    changeIcon(3);
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    break;
            }
            return true;
        });

        loadFragment(new StoreFragment());

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void insertBadge(int index) {
     /*   BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        View targetView = menuView.getChildAt(index);

        BadgeView badgeView = new BadgeView(this);
        badgeView.setTargetView(targetView);
        badgeView.setEmptyBadge();
        badgeView.setBadgeGravity(Gravity.CENTER);
        badgeView.setBadgeMargin(0, 24, 13, 0);*/
    }

    private void changeIcon(int itemIndex) {

        bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.ic_home);
        bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.ic_sports);
        bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.ic_contact);
        bottomNavigationView.getMenu().getItem(3).setIcon(R.drawable.ic_man);

        switch (itemIndex) {
            case 0:
                bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.ic_home_active);
                break;
            case 1:
                bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.ic_sports_active);
                break;
            case 2:
                bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.ic_contact_active);
                break;
            case 3:
                bottomNavigationView.getMenu().getItem(3).setIcon(R.drawable.ic_man_active);
                break;
        }
    }
}
