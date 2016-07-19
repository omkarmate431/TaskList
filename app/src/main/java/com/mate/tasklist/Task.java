package com.mate.tasklist;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * Created by omkar_000 on 7/16/2016.
 */
@AutoValue
abstract public class Task implements Parcelable {

    abstract String taskTitle();
    abstract String shortDescription();
    abstract String longDescription();
    abstract String priority();
    abstract boolean isCompleted();

    static Task create(String taskTitle, String shortDescription, String longDescription,String priority, boolean completed) {
        return new AutoValue_Task(taskTitle, shortDescription, longDescription, priority, completed);
    }

}
