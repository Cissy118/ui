package com.laioffer.vicabulary.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.laioffer.vicabulary.MainActivity;
import com.laioffer.vicabulary.model.Movie;
import com.laioffer.vicabulary.model.Word;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Video.db";
    public static final String DATABASE_NAME1 = "vocabulary.db";
    public static final String TABLE_NAME = "video_table";
    public static final String TABLE_NAME1 = "vocabulary_table";
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
        db.execSQL("drop table if exists " + TABLE_NAME1);
        db.execSQL("create table " + TABLE_NAME1 + "(WORD TEXT PRIMARY KEY , TIME INTEGER, TRANSLATION TEXT, PATH TEXT)");
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
    
    
     public void insertWord(String word, int time, String translation, String path){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("WORD", word);
        contentValues.put("TIME", time);
        contentValues.put("TRANSLATION", translation);
        contentValues.put("PATH",path);
        db.insert(TABLE_NAME1, null, contentValues);
        db.close();

    }

    public Word getWord(String word){
        SQLiteDatabase db = this.getWritableDatabase();
        Word w = new Word();
        String selectQuery = "select v.word, v.time, v.translation, v.path from " + TABLE_NAME1 + "where v.name = " + word;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            w.setWord(cursor.getString(0));
            w.setTime(cursor.getInt(1));
            w.setTranslation(cursor.getString(2));
            w.setPath(cursor.getString(3));
        }
        return w;
    }

}
