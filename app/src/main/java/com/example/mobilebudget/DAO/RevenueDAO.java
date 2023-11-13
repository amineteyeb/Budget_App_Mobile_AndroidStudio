package com.example.mobilebudget.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobilebudget.Module.Revenue;

import java.util.List;

@Dao
public interface RevenueDAO {
    @Insert
    void insertOne(Revenue revenu);

    @Delete
    void delete(Revenue revenu);

    @Query("SELECT * FROM revenu")
    List<Revenue> getAll();
}
