package com.gifmyneeds.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.gifmyneeds.dao.ChildDao;
import com.gifmyneeds.dao.UserDao;
import com.gifmyneeds.models.Child;
import com.gifmyneeds.models.User;


@Database(entities = {User.class, Child.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();
    public abstract ChildDao childDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "gif_my_needs_DB").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}