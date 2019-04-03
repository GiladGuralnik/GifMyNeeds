package com.gifmyneeds.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "child")
public class Child implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "age")
    private String age;

    @ColumnInfo(name = "gender")
    private String gender;

    public Child(String fullName, String age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}