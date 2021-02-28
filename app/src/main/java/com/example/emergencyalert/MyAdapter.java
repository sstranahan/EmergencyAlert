package com.example.emergencyalert;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                MyNews myNewsFragment = new MyNews();
                return myNewsFragment;
            case 1:
                MyMap myMapFragment = new MyMap();
                return myMapFragment;
            case 2:
                MySettings mySettingsFragment = new MySettings();
                return mySettingsFragment;
            case 3:
                MySOS mySOSFragment = new MySOS();
                return mySOSFragment;
            case 4:
                MyTraffic myTrafficFragment = new MyTraffic();
                return myTrafficFragment;
            case 5:
                MyWeather myWeatherFragment = new MyWeather();
                return myWeatherFragment;

                default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}