package com.gifmyneeds.database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.gifmyneeds.dao.ChildDao;
import com.gifmyneeds.models.Child;

import java.util.List;

public class ChildDBApi {

    private static final String TAG = "ChildDBApi";
    private static ChildDao childDao;
    private static AppDatabase db;

    private static void init(Context context) {
        db = AppDatabase.getAppDatabase(context);
        childDao = db.childDao();
    }

    public static Child getChildById(Context context, String id) {
        try {
            init(context);
            Child child = childDao.getChildById(id);
            db.close();
            return child;
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
            db.close();
            return true;
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
            Log.d(TAG, "addNewChild: " + e);
            return false;
        }
    }

    public static void deleteChild(Context context, Child child) {
        try {
            init(context);
            childDao.delete(child);
            db.close();
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
        }
    }

    public static List<Child> getChildrenOfParent(Context context, String parentEmail) {
        try {
            init(context);
            List<Child> children = childDao.findByParentEmail(parentEmail);
            db.close();
            return children;
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
            Log.d(TAG, "getChildrenOfParent: " + e);
        }
        return null;
    }
}
