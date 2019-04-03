package com.gifmyneeds.database;

import android.content.Context;

import com.gifmyneeds.dao.UserDao;
import com.gifmyneeds.models.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract UserDao userDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "gif_my_needs_DB").build();
        }
        return INSTANCE;
    }
}