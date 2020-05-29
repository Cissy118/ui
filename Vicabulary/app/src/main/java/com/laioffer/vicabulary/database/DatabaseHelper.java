package com.laioffer.vicabulary.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Time;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Video.db";
    public static final String TABLE_NAME = "video_table";
    public static final String VIDEO_ID = "ID";
    public static final String VIDEO_NAME = "NAME";
    public static final  String VIDEO_PUBLISHER = "PUBLISHER";
    public static final  String VIDEO_DURATION = "DURATION";
    public static final String VIDEO_CLIP = "CLIP";
    public static final String VIDEO_SUBTITLE = "SUBTITLE";
    public static final String VIDEO_COVER = "COVER";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, PUBLISHER TEXT, DURATION STRING, CLIP TEXT, SUBTITLE TEXT, COVER TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public boolean saveRecord(String name, String publisher, String duration, String clip, String subtitle, String cover) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(VIDEO_NAME, name);
        contentValues.put(VIDEO_PUBLISHER, publisher);
        contentValues.put(VIDEO_DURATION, duration);
        contentValues.put(VIDEO_CLIP, clip);
        contentValues.put(VIDEO_SUBTITLE, subtitle);
        contentValues.put(VIDEO_COVER, cover);
        long result =  db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
