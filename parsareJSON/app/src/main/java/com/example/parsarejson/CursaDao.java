package com.example.parsarejson;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;

import java.util.List;

@Dao
public interface CursaDao{
    @Insert
    void insert(List<Cursa> curse);


    @Query("SELECT * FROM Cursa")
        List<Cursa> getAll();


    @Query(" DELETE FROM Cursa where manual=1")
        void deleteAll();

    // CursaDao.java
    @Query("SELECT COUNT(id) FROM Cursa WHERE manual = 1")
    int countManualEntries();


}
