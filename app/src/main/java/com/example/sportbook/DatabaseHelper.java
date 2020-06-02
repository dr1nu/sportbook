package com.example.sportbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "database";
    static int version = 1;


    String createUserTable = "CREATE TABLE if not exists \"user\" (\n" +
            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t\"username\"\tTEXT,\n" +
            "\t\"password\"\tTEXT,\n" +
            "\t\"locality\"\tTEXT,\n" +
            "\t\"sport\"\tTEXT\n" +
            ")";


    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, version);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert("user","",contentValues);
    }

    public boolean isLoginValid(String username, String password){
        String sql= "Select count(*) from user where username='" + username +"' and password= '" + password +"'";
        SQLiteStatement statement= getReadableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();
        statement.close();

        if (l==1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}









