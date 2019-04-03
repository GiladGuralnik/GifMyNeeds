package com.gifmyneeds.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.gifmyneeds.models.Child;
import java.util.List;

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