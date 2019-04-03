package com.gifmyneeds.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.gifmyneeds.models.User;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE email IN (:userEmails)")
    List<User> loadAllByEmails(String[] userEmails);

    @Query("SELECT * FROM user WHERE full_name LIKE :full LIMIT 1")
    User findByName(String full);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}