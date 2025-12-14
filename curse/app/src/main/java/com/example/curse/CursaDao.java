package com.example.curse;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CursaDao {
    @Insert
     void insert(Cursa c);

    @Query("SELECT * FROM curse")
    List<Cursa> select();

    @Query("DELETE FROM curse WHERE manual=1")
    void delete();

    @Query("SELECT COUNT(id) FROM curse where manual=1")
    int nr();


}
