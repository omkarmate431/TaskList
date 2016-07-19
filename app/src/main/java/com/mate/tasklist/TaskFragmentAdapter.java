package com.mate.tasklist;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by omkar_000 on 7/16/2016.
 */
public class TaskFragmentAdapter extends FragmentPagerAdapter {
    public TaskFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        DayFragment fragment;
        switch (position)
        {
            case 0:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;

            case 1:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;

            case 2:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;

            case 3:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;
            case 4:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;

            case 5:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;

            case 6:
                fragment= new DayFragment();
                fragment.setDay(position);
                return fragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Monday";

            case 1:
                return "Tuesday";

            case 2:
                return "Wednesday";

            case 3:
                return "Thursday";

            case 4:
                return "Friday";

            case 5:
                return "Saturday";

            case 6:
                return  "Sunday";

            default:
                return null;
        }

    }
}
