package com.example.parsarejson;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cursa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CursaDao persoanaDao();
}
