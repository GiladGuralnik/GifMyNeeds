package com.gifmyneeds.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "child")
public class Child implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "age")
    private String age;

    @ColumnInfo(name = "gender")
    private String gender;

    @ColumnInfo(name = "parent_email")
    @ForeignKey(entity = User.class, parentColumns = "email", childColumns = "parent_email")
    private String parentEmail;

    public Child(String id, String fullName, String age, String gender, String parentEmail) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.parentEmail = parentEmail;
    }

    @NonNull
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

    public String getParentEmail() {
        return parentEmail;
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

    public void setParentEmail(String parentEmail) {
        this.parentEmail = parentEmail;
    }

    @NonNull
    @Override
    public String toString() {
        return fullName;
    }
}