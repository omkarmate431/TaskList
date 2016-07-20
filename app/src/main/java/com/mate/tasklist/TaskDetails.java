package com.mate.tasklist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {

    TextView title,shortDescription,longDescription,day,priority,status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        title = (TextView)findViewById(R.id.taskDetailTitle);
        shortDescription = (TextView)findViewById(R.id.taskDetailShortDescription);
        longDescription = (TextView)findViewById(R.id.taskDetailLongDescription);
        day = (TextView)findViewById(R.id.taskDetailDay);
        priority = (TextView)findViewById(R.id.taskDetailPriority);
        status = (TextView)findViewById(R.id.taskDetailStatus);

        Bundle bundle = getIntent().getExtras();
        Task task = bundle.getParcelable("task");
        title.setText(task.taskTitle());
        shortDescription.setText(task.shortDescription());
        longDescription.setText(task.longDescription());
        day.setText(task.day());
        priority.setText(task.priority());
        if(task.isCompleted())
        {
            status.setText("Task Completed");
        }
        else
        {
            status.setText("Task Incomplete");
        }


    }
}
