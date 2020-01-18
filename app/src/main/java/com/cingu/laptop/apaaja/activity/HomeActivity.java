package com.cingu.laptop.apaaja.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.cingu.laptop.apaaja.PreferenceLogin;
import com.cingu.laptop.apaaja.R;
import com.cingu.laptop.apaaja.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private BottomNavigationView bottomNav;
    private ViewPager viewPager;
    private MenuItem prevMenuItem;
    PreferenceLogin userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userSession = PreferenceLogin.getInstance(getApplicationContext());
        if (!userSession.isLogin()){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        findView();
        initView();
        listener();
    }

    public void findView() {
        bottomNav = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.vp_container);
    }

    public void initView() {
        viewPager.setAdapter(viewPagerAdapter);
        viwePager();
    }

    public void listener() {
        bottomNavigation();
    }

    private void bottomNavigation() {

        // menghendel navigasi bawah ketika di klik
        bottomNav.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    item.setIcon(R.drawable.home);
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_user:
                    item.setIcon(R.drawable.person);
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_order:
                    item.setIcon(R.drawable.order);
                    viewPager.setCurrentItem(2);
                    break;
            }
            return false;

        });

    }

    private void viwePager() {
        // menghendel viewPager ketika di swap
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // unutk merubah tampilan navigasi bawah sesuai posisi fragment yang tampil
            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNav.getMenu().getItem(0).setChecked(false);
                }

                bottomNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }

}
