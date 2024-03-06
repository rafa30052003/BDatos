package com.iesfranciscodelosrios.bdatos_alejandrogalvez_rafalucena;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ArtistaDAO {
    private DBContract dbHelper;

    public ArtistaDAO(Context context) {
        dbHelper = new DBContract(context, "your_database_name", null, 1);
    }

    public void addArtist(Artist artist) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", artist.getId());
        values.put("name", artist.getName());
        values.put("genre", artist.getGenre());
        values.put("age", artist.getAge());
        db.insert("artist", null, values);
        db.close();
    }

    public Artist getArtist(String artistId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("artist", null, "id=?", new String[]{artistId}, null, null, null);

        Artist artist = null;
        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int genreIndex = cursor.getColumnIndex("genre");
            int ageIndex = cursor.getColumnIndex("age");

            if (idIndex != -1 && nameIndex != -1 && genreIndex != -1 && ageIndex != -1) {
                artist = new Artist(
                        cursor.getString(idIndex),
                        cursor.getString(nameIndex),
                        cursor.getString(genreIndex),
                        cursor.getDouble(ageIndex)
                );
            }
            cursor.close();
        }

        db.close();
        return artist;
    }


    public void updateArtist(Artist artist) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", artist.getName());
        values.put("genre", artist.getGenre());
        values.put("age", artist.getAge());
        db.update("artist", values, "id=?", new String[]{artist.getId()});
        db.close();
    }

    public void deleteArtist(String artistId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("artist", "id=?", new String[]{artistId});
        db.close();
    }

    public List<Artist> getAllArtists() {
        List<Artist> artistList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM artist", null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex("id");
                int nameIndex = cursor.getColumnIndex("name");
                int genreIndex = cursor.getColumnIndex("genre");
                int ageIndex = cursor.getColumnIndex("age");

                if (idIndex != -1 && nameIndex != -1 && genreIndex != -1 && ageIndex != -1) {
                    Artist artist = new Artist(
                            cursor.getString(idIndex),
                            cursor.getString(nameIndex),
                            cursor.getString(genreIndex),
                            cursor.getDouble(ageIndex)
                    );
                    artistList.add(artist);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }

        db.close();
        return artistList;
    }
}