package com.example.a1234.agriculture;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {Sheet1.class},version = 1,exportSchema = true)
public abstract class LocalRoomDatabase extends RoomDatabase {
    private static final String DB_NAME = "demo_database";

    public abstract MyDao getDao();

    private static volatile LocalRoomDatabase INSTANCE;

    static LocalRoomDatabase getINSTANCE(Context context) {

        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, LocalRoomDatabase.class, DB_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
