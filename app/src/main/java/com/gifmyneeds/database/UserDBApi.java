package com.gifmyneeds.database;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.gifmyneeds.dao.UserDao;
import com.gifmyneeds.models.User;

public class UserDBApi {

    private static final String TAG = "UserDBApi";
    private static UserDao userDao;
    private static AppDatabase db;

    private static void init(Context context) {
        db = AppDatabase.getAppDatabase(context);
        userDao = db.userDao();
    }

    public static User getUserByEmail(Context context, String email) {
        try {
            init(context);
            User user = userDao.getUserByEmail(email);
            db.close();
            return user;
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    public static boolean addNewUser(Context context, User user) {
        try {
            init(context);
            userDao.insertAll(user);
            db.close();
            Log.d(TAG, "addNewUser: added!");
            return true;
        }
        catch (Throwable e) {
            Log.d(TAG, "addNewUser: " + e.toString());
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public static void deleteUser(Context context, User user) {
        try {
            init(context);
            userDao.delete(user);
            db.close();
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
        }
    }
}
