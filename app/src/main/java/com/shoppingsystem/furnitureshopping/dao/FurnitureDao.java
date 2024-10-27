package com.shoppingsystem.furnitureshopping.dao; // Replace with your actual package name

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import com.shoppingsystem.furnitureshopping.model.Furniture; // Ensure to import the Furniture model

@Dao
public interface FurnitureDao {

    @Insert
    void insert(Furniture furniture);

    @Update
    void update(Furniture furniture);

    @Delete
    void delete(Furniture furniture);

    @Query("SELECT * FROM furniture")
    List<Furniture> getAllFurniture();

    @Query("DELETE FROM furniture")
    void deleteAllFurniture();
}
