package com.example.appoitmentproject;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

 public class bookingDatabase extends SQLiteOpenHelper {

    private static final String Database_name="appointment.db";
    private static final int Database_version=1;
    private final String Sql_create_country_table="CREATE TABLE " + data.Nationentry.Tname+
            "(" + data.Nationentry._id+" Integer Primary Key AUTOINCREMENT, "+
            data.Nationentry.Col_country+" TEXT NOT NULL,"+ data.Nationentry.Col_Cont+" TEXT " + ")";




     public bookingDatabase(@Nullable Context context) {
         super(context, "appointment.db", null, 1);
     }

     @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Sql_create_country_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
