package com.gifmyneeds.dao;

import com.gifmyneeds.models.User;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

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