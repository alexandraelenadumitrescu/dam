package com.example.parsarejson;

import androidx.room.Dao;
import androidx.room.Database;
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

}
