package com.example.com.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GroupDialog.GroupDialogListener, ItemaAdpater.OnItemClickListener {

    private RecyclerView mrecyclerView;
    private ItemaAdpater mitemAdpter;
    private SQLiteDatabase mDatabase;
    private Button NameGroup;
    private int mAmount = 0;
    private ArrayList<String> AllIist;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(" Main view");

        mrecyclerView = (RecyclerView) findViewById(R.id.main_Screen);
        NameGroup     = (Button)       findViewById(R.id.Bname_group);

        DataBaseSQLite dbHelper = new DataBaseSQLite(this);
        mDatabase = dbHelper.getWritableDatabase();
        AllIist=new ArrayList<>();

        mitemAdpter =new ItemaAdpater(this,  AllIist,0,this);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerView.setAdapter(mitemAdpter);


    }

    private Cursor getAllItems() {
        return mDatabase.query(
                GroupContantDB.GroupEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                GroupContantDB.GroupEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }

/*    private void createDB() {

        File f = getApplicationContext().getDatabasePath("Group.db");

        mDatabase = SQLiteDatabase.openDatabase(f.getAbsolutePath(), null,
                SQLiteDatabase.CREATE_IF_NECESSARY|SQLiteDatabase.OPEN_READWRITE);
        String S=mDatabase.findEditTable("GroupName");

        mDatabase.execSQL("create table if not exists GroupName  ("
                + "name  text PRIMary key );");
    }

    private void deleteDB()
    {
      //  String S= String.format("delete from GroupName where name='%s'",name.getText());
       // db.execSQL(S);
    }
    */
    private void insertDB(String NameGroup)
    {
        if (NameGroup.length() == 0 ) {
            return;
        }

        ContentValues cv = new ContentValues();
        cv.put(GroupContantDB.GroupEntry.COLUMN_NAME, NameGroup);
        cv.put(GroupContantDB.GroupEntry.COLUMN_TIMESTAMP, "5");


        mDatabase.insert(GroupContantDB.GroupEntry.TABLE_NAME, null, cv);
        mitemAdpter.swapCursor(getAllItems());
        mDatabase.close();

    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater flater= getMenuInflater();
        flater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent;
        switch( item.getItemId()){
            case R.id.list:
                Toast.makeText(this, "Manage the menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.group:
                GroupDialog exampleDialog = new GroupDialog();
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
                Toast.makeText(this, "group", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Deleting:
                Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show();
            return true;
            case R.id.Expense:
                Toast.makeText(this, "Expense", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.inside:
                 myIntent = new Intent(MainActivity.this,Inside_Expense.class);
                Toast.makeText(this, "inside Expense", Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
                return true;
            case R.id.Outside:
                 myIntent = new Intent(MainActivity.this,Outside_Expense.class);
                Toast.makeText(this, "Outside Expense", Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
                return true;
            case R.id.Profit:
                myIntent = new Intent(MainActivity.this,Net_profit.class);
                Toast.makeText(this, " Net profit", Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
                return true;
            case R.id.consumed:
                myIntent = new Intent(MainActivity.this,Most_consumed.class);
                Toast.makeText(this, "Most consumed", Toast.LENGTH_SHORT).show();
                startActivity(myIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void applyTexts(String NameGroup) {
          AllIist.add(NameGroup);
      // insertDB(NameGroup);
    }

    @Override
    public void onItemClick(int item) {


    }
}
