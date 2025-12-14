package com.example.curse;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Cursa.class}, version = 1)
public  abstract class Db extends RoomDatabase {
    public abstract CursaDao cursaDao();
    private static final int NUMBER_OF_THREADS=4;
    public static final ExecutorService dbWriteExec= Executors.newFixedThreadPool(NUMBER_OF_THREADS);
}
