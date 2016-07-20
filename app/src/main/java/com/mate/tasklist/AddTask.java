package com.mate.tasklist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.days_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.priority_array, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerDay.setAdapter(adapter1);
        spinnerPriority.setAdapter(adapter2);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddTask.this).setTitle("Confirmation")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if(taskDbHelper.addTask(taskTitle.getText().toString(),taskShortDescription.getText().toString()
                                        ,taskLongDescription.getText().toString(),spinnerPriority.getSelectedItem().toString()
                                        ,spinnerDay.getSelectedItem().toString(),false))
                                {
                                    Toast.makeText(AddTask.this,"Task Added",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(AddTask.this,"Task Not Added",Toast.LENGTH_LONG).show();
                                }
                                Intent intent = new Intent(AddTask.this,MainActivity.class);       //Task Added. Go to mainpage
                                startActivity(intent);
                            }
                        }).setNegativeButton("No",null).setCancelable(false);
                AlertDialog alert = alertDialog.create();
                alert.show();





            }
        });

    }
}
