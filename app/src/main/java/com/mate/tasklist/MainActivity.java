package com.mate.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        TaskFragmentAdapter taskFragmentAdapter = new TaskFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(taskFragmentAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);

        tabLayout.setupWithViewPager(viewPager);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.add_task_float_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddTask.class);
                startActivity(intent);
            }
        });

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        System.out.println("Current Day "+dayOfTheWeek);
        switch (dayOfTheWeek)
        {
            case "Monday":
                viewPager.setCurrentItem(0);
                break;
            case "Tuesday":
                viewPager.setCurrentItem(1);
                break;
            case "Wednesday":
                viewPager.setCurrentItem(2);
                break;
            case "Thursday":
                viewPager.setCurrentItem(3);
                break;
            case "Friday":
                viewPager.setCurrentItem(4);
                break;
            case "Saturday":
                viewPager.setCurrentItem(5);
                break;
            case "Sunday":
                viewPager.setCurrentItem(6);
                break;
            default:
                break;
        }


    }
}
