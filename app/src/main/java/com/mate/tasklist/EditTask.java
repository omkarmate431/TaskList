package com.mate.tasklist;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTask extends AppCompatActivity {

    EditText title,shortDescription,longDescription,priority;
    Button saveChangesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        Intent intent = getIntent();
        final long id =intent.getLongExtra("ID",0);
        System.out.println("Testing int "+id);
        title = (EditText)findViewById(R.id.edit1TaskTitle);
        shortDescription=(EditText)findViewById(R.id.edit1ShortDescription);
        longDescription=(EditText)findViewById(R.id.edit1LongDescription);
        saveChangesButton=(Button)findViewById(R.id.saveChangesBtn);

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
                                //contentValues.put("priority", priority);
                                //contentValues.put("isCompleted", isCompleted);
                                db.update("MondayTask",contentValues,"_id="+id,null);
                            }
                        }).setNegativeButton("No",null).setCancelable(false);
                AlertDialog alert = alertDialog.create();
                alert.show();


                Toast.makeText(EditTask.this,"Changes Saved",Toast.LENGTH_LONG).show();
            }
        });


    }
}
