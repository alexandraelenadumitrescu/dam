package com.example.afinal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CursaDao {
    @Insert
    void add(Cursa c);
    @Query("SELECT * FROM cursa")
    List<Cursa> getAll();
    @Query("DELETE FROM CURSA where manual=false")
    void delall();
    @Query("SELECT COUNT(*) FROM Cursa")
    int numar();
    @Query("SELECT COUNT(*) FROM Cursa where manual=true")
    int numarmanual();

}
