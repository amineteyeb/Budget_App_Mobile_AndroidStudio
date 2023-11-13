package com.example.mobilebudget.Module;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "facture", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "uid", childColumns = "user_id"))
public class Facture {
    @PrimaryKey(autoGenerate = true)
    private int factureId;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "amount")
    private double amount;

    // Ajoutez d'autres champs nécessaires pour décrire une facture

    public Facture() {}

    public int getFactureId() {
        return factureId;
    }

    public void setFactureId(int factureId) {
        this.factureId = factureId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
