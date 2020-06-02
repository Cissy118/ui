package com.laioffer.vicabulary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.laioffer.vicabulary.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private DatabaseHelper dbHelper;

//    public static void main(String[] args) {
//        DatabaseAdapter
//    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM " + dbHelper.TABLE_NAME;
        VideoDatabase.CreateDatabase(dbHelper);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(dbHelper.VIDEO_ID);
            int index2 = cursor.getColumnIndex(dbHelper.VIDEO_NAME);
            int index3 = cursor.getColumnIndex(dbHelper.VIDEO_PUBLISHER);
            int index4 = cursor.getColumnIndex(dbHelper.VIDEO_DURATION);
            int index5 = cursor.getColumnIndex(dbHelper.VIDEO_CLIP);
            int index6 = cursor.getColumnIndex(dbHelper.VIDEO_SUBTITLE);
            int index7 = cursor.getColumnIndex(dbHelper.VIDEO_COVER);
            String id = cursor.getString(index);
            String name = cursor.getString(index2);
            String publisher = cursor.getString(index3);
            String duration = cursor.getString(index4);
            String clip = cursor.getString(index5);
            String subtitle = cursor.getString(index6);
            String cover = cursor.getString(index7);
            movies.add(new Movie(id, name, publisher, duration, clip, subtitle, cover));
        }
        return movies;
    }
}
