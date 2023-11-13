package com.example.mobilebudget.Module;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "revenu", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "uid", childColumns = "user_id"))
public class Revenue {
    @PrimaryKey(autoGenerate = true)
    private int revenuId;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "amount")
    private double amount;

    // Ajoutez d'autres champs nécessaires pour décrire un revenu

    public Revenue() {}

    public int getRevenuId() {
        return revenuId;
    }

    public void setRevenuId(int revenuId) {
        this.revenuId = revenuId;
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
