package com.mate.tasklist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    EditText taskTitle,taskShortDescription,taskLongDescription;
    Spinner spinner;
    Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final TaskDbHelper taskDbHelper = new TaskDbHelper(this);

        taskTitle = (EditText)findViewById(R.id.editTaskTitle);
        taskShortDescription=(EditText)findViewById(R.id.editShortDescription);
        taskLongDescription = (EditText)findViewById(R.id.editLongDescription);
        addTaskButton = (Button)findViewById(R.id.addTaskBtn);

        spinner = (Spinner) findViewById(R.id.spinner_day);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.days_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        spinner.setAdapter(adapter);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option = spinner.getSelectedItem().toString();
                switch (option)
                {
                    case "Monday":
                        if(taskDbHelper.addTaskMonday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                            {Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                            }
                        break;
                    case "Tuesday":
                        if(taskDbHelper.addTaskTuesday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                        {
                            Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Wednesday":
                        if(taskDbHelper.addTaskWednesday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                        {
                            Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Thursday":
                        if(taskDbHelper.addTaskThursday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                        {
                            Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case "Friday":
                        if(taskDbHelper.addTaskFriday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                    {
                        Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                    }
                        break;
                    case "Saturday":
                        if(taskDbHelper.addTaskSaturday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                    {
                        Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                    }
                        break;
                    case "Sunday":
                        if(taskDbHelper.addTaskSunday(taskTitle.getText().toString(),taskShortDescription.getText().toString(),taskLongDescription.getText().toString(),"High",false))
                    {
                        Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                    }
                        break;


                }


            }
        });

    }
}
