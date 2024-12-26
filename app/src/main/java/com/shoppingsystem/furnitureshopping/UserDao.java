package com.shoppingsystem.furnitureshopping;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

    @Insert
    void insertRecord(User users);

}
