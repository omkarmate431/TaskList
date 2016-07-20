package com.mate.tasklist;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment {

    int day;
    TaskAdapter1 taskAdapter1;
    Cursor taskCursor;
    TaskDbHelper taskDbHelper;
    public DayFragment() {
        // Required empty public constructor
    }

    public void setDay(int pos)
    {
        this.day=pos;
    }

    public int getDay() {
        return day;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.task_list, container,
                false);

        final TaskDbHelper taskDbHelper = new TaskDbHelper(getActivity());

        SQLiteDatabase db = taskDbHelper.getReadableDatabase();

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        registerForContextMenu(listView);


        switch (getDay())
        {
            case 0:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Monday"+"'", null);
                break;

            case 1:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Tuesday"+"'", null);
                break;

            case 2:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Wednesday"+"'", null);
                break;

            case 3:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Thursday"+"'", null);
                break;

            case 4:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Friday"+"'", null);
                break;

            case 5:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Saturday"+"'", null);
                break;

            case 6:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day= '"+"Sunday"+"'", null);
                break;

            default:
                taskCursor = db.rawQuery("SELECT * FROM AllTasks WHERE day=Monday", null);
                break;

        }

        taskAdapter1 = new TaskAdapter1(getActivity(),taskCursor);
        listView.setAdapter(taskAdapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cursor taskCursor = (Cursor) parent.getItemAtPosition(position);
                if (taskCursor.moveToPosition(position)) {
                    Task task = getTaskFromCursor(taskCursor);

                    Intent intent = new Intent(getActivity(),TaskDetails.class);
                    intent.putExtra("task", task);

                    getActivity().startActivity(intent);
                }
            }
        });
        return rootView;
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


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Actions");
        if (v.getId()==R.id.list) {
            MenuInflater inflater = getActivity().getMenuInflater();
            inflater.inflate(R.menu.task_menu_list, menu);
        }
    }




    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();


        switch(item.getItemId()) {
            case R.id.edit:
                Intent intent1 =new Intent(getActivity(),EditTask.class);
                intent1.putExtra("ID",info.id);
                startActivity(intent1);

                return true;
            case R.id.delete:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity()).setTitle("Confirmation")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                taskDbHelper = new TaskDbHelper(getActivity());

                                taskDbHelper.removeTask(info.id);


                                Toast.makeText(getActivity(),"Task Deleted",Toast.LENGTH_LONG).show();
                                Intent intent2 =new Intent(getActivity(),MainActivity.class);
                                startActivity(intent2);
                            }
                        }).setNegativeButton("No",null).setCancelable(false);
                AlertDialog alert = alertDialog.create();
                alert.show();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
