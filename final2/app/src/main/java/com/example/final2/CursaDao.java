package com.example.final2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CursaDao {
    @Insert
    void add(Cursa c);
    @Query("SELECT COUNT(*) FROM CURSA")
    int numar();
    @Query("DELETE FROM CURSA WHERE manual=0")
    void deleteManual();
    @Query("SELECT * FROM CURSA")
    List<Cursa> getAll();




}
