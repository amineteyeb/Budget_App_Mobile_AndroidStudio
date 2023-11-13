package com.example.mobilebudget.Module;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "categorie")
public class Categorie {
    @PrimaryKey(autoGenerate = true)
    private int categoryId;

    @ColumnInfo(name = "category_name")
    private String categoryName;

    // Ajoutez d'autres champs nécessaires pour décrire une catégorie

    public Categorie() {}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
