package com.mate.tasklist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTask extends AppCompatActivity {

    EditText taskTitle,taskShortDescription,taskLongDescription;
    Spinner spinnerDay,spinnerPriority;
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

        spinnerDay = (Spinner) findViewById(R.id.spinner_day);
        spinnerPriority = (Spinner)findViewById(R.id.spinner_priority);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.days_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.priority_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner

        spinnerDay.setAdapter(adapter1);
        spinnerPriority.setAdapter(adapter2);

        spinnerPriority.getSelectedItem().toString();
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taskDbHelper.addTask(taskTitle.getText().toString(),taskShortDescription.getText().toString()
                        ,taskLongDescription.getText().toString(),spinnerPriority.getSelectedItem().toString(),spinnerDay.getSelectedItem().toString(),false))
                {
                    Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
