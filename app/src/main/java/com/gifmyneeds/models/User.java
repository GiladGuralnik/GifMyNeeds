package com.gifmyneeds.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "user")
public class User implements Serializable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "password")
    private String password;

    public User(@NonNull String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
