package com.iesfranciscodelosrios.bdatos_alejandrogalvez_rafalucena;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBContract extends SQLiteOpenHelper {

    public DBContract(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBContract(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }



    @Override
    public void onCreate(SQLiteDatabase Spotyfy) {
        Spotyfy.execSQL(
                "CREATE TABLE artist (" +
                        "id TEXT PRIMARY KEY," +
                        "name TEXT," +
                        "genre TEXT," +
                        "age REAL" +
                        ");"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
