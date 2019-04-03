package com.gifmyneeds.dao;

import com.gifmyneeds.models.Child;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ChildDao {
    @Query("SELECT * FROM child")
    List<Child> getAll();

    @Query("SELECT * FROM child WHERE id IN (:childId)")
    List<Child> loadAllById(String[] childId);

    @Query("SELECT * FROM child WHERE full_name LIKE :full LIMIT 1")
    Child findByName(String full);

    @Insert
    void insertAll(Child... children);

    @Delete
    void delete(Child child);
}