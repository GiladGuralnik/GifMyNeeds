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

    @Query("SELECT * FROM child WHERE id = :childId")
    Child getChildById(String childId);

    @Query("SELECT * FROM child WHERE full_name LIKE :fullName")
    List<Child> findByName(String fullName);

    @Query("SELECT * FROM child WHERE parent_email = :parentEmail")
    List<Child> findByParentEmail(String parentEmail);

    @Insert
    void insertAll(Child... children);

    @Delete
    void delete(Child child);
}