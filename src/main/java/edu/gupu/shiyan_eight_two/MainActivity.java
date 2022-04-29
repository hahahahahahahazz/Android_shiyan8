package edu.gupu.shiyan_eight_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private  MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick (View v){
            dbHelper.getWritableDatabase();
        }

    });
        Button addData=(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                SQLiteDatabase db =dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();

                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",456);
                values.put("price",16.96);
                db.insert("Book",null,values);
                values.clear();

                values.put("name","The D");
                values.put("author","Dan Br");
                values.put("pages",451);
                values.put("price",16.00);
                db.insert("Book",null,values);
            }
    });
    }

}