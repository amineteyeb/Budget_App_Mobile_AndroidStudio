package com.example.mobilebudget.Module;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "depense", foreignKeys = @ForeignKey(entity = User.class, parentColumns = "uid", childColumns = "user_id"))
public class Depense {
    @PrimaryKey(autoGenerate = true)
    private int depenseId;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "amount")
    private double amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ColumnInfo(name = "Date")
    private Date date;

    // Ajoutez d'autres champs nécessaires pour décrire une dépense

    public Depense() {}

    public int getDepenseId() {
        return depenseId;
    }

    public void setDepenseId(int depenseId) {
        this.depenseId = depenseId;
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
