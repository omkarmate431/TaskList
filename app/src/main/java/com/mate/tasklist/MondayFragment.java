package com.mate.tasklist;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MondayFragment extends Fragment {

    public MondayFragment() {
        // Required empty public constructor
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

        Cursor taskCursor = db.rawQuery("SELECT * FROM MondayTask", null);
        System.out.println("Row Count "+taskCursor.getCount());
        TaskAdapter1 taskAdapter1 = new TaskAdapter1(getActivity(),taskCursor);
        listView.setAdapter(taskAdapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Cursor taskCursor = (Cursor) parent.getItemAtPosition(position);
                if (taskCursor.moveToPosition(position)) {
                    Task task = getTaskFromCursor(taskCursor);

                    Intent intent = new Intent(getActivity(),TaskDetails.class);
                    intent.putExtra("task",  task);


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
        boolean isCompleted = cursor.getInt(cursor.getColumnIndexOrThrow("isCompleted"))>0; //From StackOverflow

        return Task.create(title, short_description, long_description, priority, isCompleted);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId()==R.id.list) {
            MenuInflater inflater = getActivity().getMenuInflater();
            inflater.inflate(R.menu.task_menu_list, menu);
        }
    }




    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {

            case R.id.edit:

                return true;
            case R.id.delete:

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
