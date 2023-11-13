package com.example.mobilebudget.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobilebudget.Module.Facture;

import java.util.List;

@Dao
public interface FactureDAO {
    @Insert
    void insertOne(Facture facture);

    @Delete
    void delete(Facture facture);

    @Query("SELECT * FROM facture")
    List<Facture> getAll();
}
