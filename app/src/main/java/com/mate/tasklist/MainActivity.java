package com.mate.tasklist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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



    }
}
