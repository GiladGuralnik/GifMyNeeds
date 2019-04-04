package com.gifmyneeds.database;

import android.content.Context;
import android.widget.Toast;
import com.gifmyneeds.dao.UserDao;
import com.gifmyneeds.models.User;

public class UserDBApi {

    private static UserDao userDao;

    private static void init(Context context) {
        AppDatabase db = AppDatabase.getAppDatabase(context);
        userDao = db.userDao();
    }

    public static User getUserByEmail(Context context, String email) {
        try {
            init(context);
            return userDao.getUserByEmail(email);
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
            return true;
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public static void deleteUser(Context context, User user) {
        try {
            init(context);
            userDao.delete(user);
        }
        catch (Throwable e) {
            Toast.makeText(context, "Database Error", Toast.LENGTH_LONG).show();
        }
    }
}
