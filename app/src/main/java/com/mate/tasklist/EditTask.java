package com.mate.tasklist;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditTask extends AppCompatActivity {

    EditText title,shortDescription,longDescription;
    Spinner spinnerDay,spinnerPriority;
    Button saveChangesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        Intent intent = getIntent();
        final long id =intent.getLongExtra("ID",0);

        title = (EditText)findViewById(R.id.edit1TaskTitle);
        shortDescription=(EditText)findViewById(R.id.edit1ShortDescription);
        longDescription=(EditText)findViewById(R.id.edit1LongDescription);
        saveChangesButton=(Button)findViewById(R.id.saveChangesBtn);

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

        TaskDbHelper taskDbHelper1 = new TaskDbHelper(EditTask.this);
        SQLiteDatabase db = taskDbHelper1.getReadableDatabase();
        Cursor taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE _id= '"+id+"'", null);
        taskCursor.moveToFirst();

        while (taskCursor.isAfterLast() == false) {
            if (taskCursor.getInt(taskCursor.getColumnIndex("_id")) == id)      //Go to the selected task's row
            {
                break;
            }
            else {
                taskCursor.moveToNext();
            }
        }

        Task task = getTaskFromCursor(taskCursor);

        title.setText(task.taskTitle());
        shortDescription.setText(task.shortDescription());
        longDescription.setText(task.longDescription());
        spinnerDay.setSelection(adapter1.getPosition(task.day()));
        spinnerPriority.setSelection(adapter2.getPosition(task.priority()));

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(EditTask.this).setTitle("Confirmation")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TaskDbHelper taskDbHelper = new TaskDbHelper(EditTask.this);

                                SQLiteDatabase db = taskDbHelper.getWritableDatabase();
                                ContentValues contentValues = new ContentValues();

                                contentValues.put("title", title.getText().toString());
                                contentValues.put("short_description", shortDescription.getText().toString());
                                contentValues.put("long_description", longDescription.getText().toString());
                                contentValues.put("priority", spinnerPriority.getSelectedItem().toString());
                                contentValues.put("day", spinnerDay.getSelectedItem().toString());
                                //contentValues.put("isCompleted", isCompleted);
                                db.update("AllTasks",contentValues,"_id="+id,null);

                                Toast.makeText(EditTask.this,"Changes Saved",Toast.LENGTH_LONG).show();

                                Intent intent = new Intent(EditTask.this,MainActivity.class);       //Edit Successful. Go to mainpage
                                startActivity(intent);
                            }
                        }).setNegativeButton("No",null).setCancelable(false);
                AlertDialog alert = alertDialog.create();
                alert.show();



            }
        });


    }
    private Task getTaskFromCursor(Cursor cursor) {
        // Extract properties from cursor
        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String short_description = cursor.getString(cursor.getColumnIndexOrThrow("short_description"));
        String long_description = cursor.getString(cursor.getColumnIndexOrThrow("long_description"));
        String priority = cursor.getString(cursor.getColumnIndexOrThrow("priority"));
        String day = cursor.getString(cursor.getColumnIndexOrThrow("day"));
        boolean isCompleted = cursor.getInt(cursor.getColumnIndexOrThrow("isCompleted"))>0; //From StackOverflow

        return Task.create(title, short_description, long_description, priority,day, isCompleted);
    }
}
