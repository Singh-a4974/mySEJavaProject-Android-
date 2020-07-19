package com.example.appoitmentproject;



import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bookappointment extends AppCompatActivity {
    private EditText econt,enewupdatecountry,enewcont,ecountrytodel,ecountry;
    private Button btninsert,btnupdate,btndelete,btnqueryrowbyid,displayallbtn;
    private static final String TAG= Bookappointment.class.getSimpleName();
    private SQLiteDatabase database;
    private bookingDatabase dhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookappointment);
        ecountry=findViewById(R.id.datetoadd);
        econt=findViewById(R.id.timetoadd);
        enewupdatecountry=findViewById(R.id.dateupdate);
        enewcont=findViewById(R.id.timeupdate);
        //equeryrid=findViewById(R.id.Rowid);
        ecountrytodel=findViewById(R.id.findbydate);
        dhelper= new bookingDatabase(this);
        database=dhelper.getWritableDatabase();
        findViewById(R.id.insertbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        findViewById(R.id.delbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.Update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryrowbyid();
            }
        });
        findViewById(R.id.displaybtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayall();
            }
        });

    }

    private void queryrowbyid() {
//        String rowid=equeryrid.getText().toString();
//        String[] proj={
//           data.Nationentry._id,
//           data.Nationentry.Col_country,
//                data.Nationentry.Col_Cont
//        };
//        String Selection=data.Nationentry._id +" = ? ";
//        String[] selectarg={rowid};
//        String sortOrder= null;
//        Cursor cursor=database.query(data.Nationentry.Tname,
//                proj,Selection,selectarg,null,null,null);
//        if(cursor!=null)
//        {
//
//            String str="";
//            while(cursor.moveToNext())
//            {
//                String[] columns=cursor.getColumnNames();
//                for(String column: columns)
//                {
//                    str+="\t"+cursor.getString(cursor.getColumnIndex(column));
//
//                }
//
//                str+="\n";
//            }
//
//            Log.i(TAG,str);
//
//            cursor.close();

    }




    private void update() {
        String  setcto=enewupdatecountry.getText().toString();
        String ncont= enewcont.getText().toString();
        String select=data.Nationentry.Col_country +"= ?";
        String []selectarg={setcto};
        ContentValues cv= new ContentValues();
        cv.put(data.Nationentry.Col_Cont,ncont);
        int changed= database.update(data.Nationentry.Tname,cv,select,selectarg);
        Log.i(TAG,"no of rows updated"+changed);






    }
    private void insert() {
        String cname= ecountry.getText().toString();
        String contname= econt.getText().toString();
        ContentValues cv= new ContentValues();
        cv.put(data.Nationentry.Col_country,cname);
        cv.put(data.Nationentry.Col_Cont,contname);
        Long rowid= database.insert(data.Nationentry.Tname,null,cv);
        Log.i(TAG,"Items are inserted havinfg row id"+rowid);



    }
    private void displayall() {
        String[] projection={
                data.Nationentry._id,
                data.Nationentry.Col_country,
                data.Nationentry.Col_Cont
        };
        String selection=null;
        String[]selectionArg=null;
        Cursor cursor=database.query(data.Nationentry.Tname,
                projection,
                selection,
                selectionArg,
                null,
                null,
                null);
        if(cursor!=null)
        {

            String str="";
            while(cursor.moveToNext())
            {
                String[] columns=cursor.getColumnNames();
                for(String column: columns)
                {
                    str+="\t"+cursor.getString(cursor.getColumnIndex(column));

                }

                str+="\n";
            }

            Log.i(TAG,str);

            cursor.close();


        }


    }
    private void delete() {

        String cname= ecountrytodel.getText().toString();
        String sel=data.Nationentry.Col_country+" = ? ";
        String[] selectar={cname};
        int rdel= database.delete(data.Nationentry.Tname,sel,selectar);
        Log.i(TAG,"Deleted rows "+rdel);




    }
    protected void onDestroy()
    {
        database.close();
        super.onDestroy();
    }
}