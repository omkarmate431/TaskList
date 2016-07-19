package com.mate.tasklist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by omkar_000 on 7/17/2016.
 */
public class TaskAdapter1 extends CursorAdapter {

    public TaskAdapter1(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView taskName = (TextView) view.findViewById(R.id.taskName);
        TextView taskShortDescription = (TextView) view.findViewById(R.id.taskShortDescription);
        TextView taskPriority = (TextView) view.findViewById(R.id.taskPriority);
        ImageView task_completed_image = (ImageView)view.findViewById(R.id.task_completed_image);

        // Extract properties from cursor
        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String short_description = cursor.getString(cursor.getColumnIndexOrThrow("short_description"));
        String priority = cursor.getString(cursor.getColumnIndexOrThrow("priority"));
        boolean isCompleted = cursor.getInt(cursor.getColumnIndexOrThrow("isCompleted"))>0; //From StackOverflow

        if(isCompleted==true)
        {
            task_completed_image.setImageResource(R.drawable.task_completed);
        }

        // Populate fields with extracted properties
        taskName.setText(title);
        taskShortDescription.setText(short_description);
        taskPriority.setText(priority);
    }
}
