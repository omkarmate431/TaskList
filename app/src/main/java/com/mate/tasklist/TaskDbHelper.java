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
        db.execSQL("create table if not exists MondayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists TuesdayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists WednesdayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists ThursdayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists FridayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists SaturdayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists SundayTask (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+ISCOMPLETED+" boolean)");
        db.execSQL("create table if not exists AllTasks (_id integer primary key autoincrement, "+TITLE+" text, "+SHORT_DESCRIPTION+" text, "+LONG_DESCRIPTION+" text, "+PRIORITY+" text, "+DAY+" text, "+ISCOMPLETED+" boolean)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        {
            db.execSQL("drop table if exists MondayTask");
            db.execSQL("drop table if exists TuesdayTask");
            db.execSQL("drop table if exists WednesdayTask");
            db.execSQL("drop table if exists ThursdayTask");
            db.execSQL("drop table if exists FridayTask");
            db.execSQL("drop table if exists SaturdayTask");
            db.execSQL("drop table if exists SundayTask");
            db.execSQL("drop table if exists AllTasks");
            onCreate(db);
        }
    }

    public boolean addTaskMonday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("MondayTask", null, contentValues);
        return true;
    }

    public boolean addTaskTuesday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("TuesdayTask", null, contentValues);
        return true;
    }

    public boolean addTaskWednesday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("WednesdayTask", null, contentValues);
        return true;
    }

    public boolean addTaskThursday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("ThursdayTask", null, contentValues);
        return true;
    }

    public boolean addTaskFriday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("FridayTask", null, contentValues);
        return true;
    }

    public boolean addTaskSaturday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("SaturdayTask", null, contentValues);
        return true;
    }
    public boolean addTaskSunday(String title, String short_description, String long_description, String priority, Boolean isCompleted)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", title);
        contentValues.put("short_description", short_description);
        contentValues.put("long_description", long_description);
        contentValues.put("priority", priority);
        contentValues.put("isCompleted", isCompleted);
        db.insert("SundayTask", null, contentValues);
        return true;
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

    public String[] retrieveTaskMonday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};
        Cursor cursor = db.query("MondayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)};
        //cursor.moveToNext();
        return row;

    }
    public String[] retrieveTaskTuesday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};

        Cursor cursor = db.query("TuesdayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)};
        //cursor.moveToNext();
        return row;

    }
    public String[] retrieveTaskWednesday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};

        Cursor cursor = db.query("WednesdayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)};
        //cursor.moveToNext();
        return row;

    }
    public String[] retrieveTaskThursday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};

        Cursor cursor = db.query("ThursdayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)};
        //cursor.moveToNext();
        return row;

    }
    public String[] retrieveTaskFriday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};

        Cursor cursor = db.query("FridayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)};
        //cursor.moveToNext();
        return row;

    }
    public String[] retrieveTaskSaturday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};

        Cursor cursor = db.query("SaturdayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)};
        //cursor.moveToNext();
        return row;

    }public String[] retrieveTaskSunday(int pos)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String projection[]={"title","short_description","long_description","priority","isCompleted"};

        Cursor cursor = db.query("SundayTask",projection,null,null,null,null,null);
        cursor.moveToPosition(pos);
        String[] row = {cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)};
        //cursor.moveToNext();
        return row;

    }


    public int getTaskCount()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String countQuery="SELECT * FROM MondayTask";
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        return count;
    }

    public void removeTask(long id){
        String string =String.valueOf(id);
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM AllTasks WHERE _id = '" + string + "'");
    }


}
