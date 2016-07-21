package com.mate.tasklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by omkar_000 on 7/17/2016.
 */
public class TaskDbHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "/data/data/com.mate.tasklist/databases/";

    private static String DB_NAME = "Tasks.db";

    private static String TITLE = "title";
    private static String SHORT_DESCRIPTION = "short_description";
    private static String LONG_DESCRIPTION = "long_description";
    private static String PRIORITY = "priority";
    private static String DAY = "day";
    private static String ISCOMPLETED = "isCompleted";


    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public TaskDbHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                db.execSQL("create table if not exists AllTasks (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+DAY+" text, "+ISCOMPLETED+" boolean)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        {
            db.execSQL("drop table if exists AllTasks");
            onCreate(db);
        }
    }



    public boolean addTask(String title, String short_description, String long_description, String priority, String day,Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("day",day);
        contentValues.put("isCompleted", isCompleted);
        db.insert("AllTasks", null, contentValues);
        return true;
    }

    public int getTaskCount()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery="SELECT * FROM AllTasks";
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        return count;
    }

    public void removeTask(long id){
        String string =String.valueOf(id);
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM AllTasks WHERE _id = '" + string + "'");
    }

    public void markDone(long id){
        String string =String.valueOf(id);
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE AllTasks SET isCompleted = "+true+" WHERE _id = '" + string + "'");
    }


}
