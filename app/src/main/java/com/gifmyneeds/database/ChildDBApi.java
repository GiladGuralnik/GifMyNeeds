package com.gifmyneeds.database;

import android.content.Context;
import android.widget.Toast;
import com.gifmyneeds.dao.ChildDao;
import com.gifmyneeds.models.Child;

public class ChildDBApi {
    private static ChildDao childDao;

    private static void init(Context context) {
        AppDatabase db = AppDatabase.getAppDatabase(context);
        childDao = db.childDao();
    }

    public static Child getChildById(Context context, String id) {
        try {
            init(context);
            return childDao.getChildById(id);
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    public static boolean addNewChild(Context context, Child child) {
        try {
            init(context);
            childDao.insertAll(child);
            return true;
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public static void deleteChild(Context context, Child child) {
        try {
            init(context);
            childDao.delete(child);
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
        }
    }
}
