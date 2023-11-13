package com.example.mobilebudget.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobilebudget.Module.Categorie;
import com.example.mobilebudget.Module.User;

import java.util.List;

@Dao
public interface CategorieDAO {
    @Insert
    void insertOne(Categorie categorie);
    @Delete
    void delete(Categorie categorie);
    @Query("SELECT * FROM categorie")
    List<User> getAll();
}
