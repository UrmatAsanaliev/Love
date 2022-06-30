package com.example.hw_6_5_m.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.hw_6_5_m.data.entity.historymodel.HistoryModel;

@Database(entities = {HistoryModel.class}, version = 1)
public abstract class LoveDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "LoveDataBase";
    public abstract LoveDao caseDao();
}
