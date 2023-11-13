package com.example.mobilebudget.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobilebudget.Module.Depense;

import java.util.List;

@Dao
public interface DepenseDAO {
    @Insert
    void insertOne(Depense depense);

    @Delete
    void delete(Depense depense);

    @Query("SELECT * FROM depense")
    List<Depense> getAll();
}
