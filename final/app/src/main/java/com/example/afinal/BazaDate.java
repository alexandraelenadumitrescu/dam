package com.example.afinal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Cursa.class},version = 1)
public abstract class BazaDate extends RoomDatabase {
    public abstract CursaDao cursaDao();
}
