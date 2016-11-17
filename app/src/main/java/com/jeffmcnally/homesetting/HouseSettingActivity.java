package com.jeffmcnally.homesetting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.res.Resources;
import android.widget.Toast;

public class HouseSettingActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "HouseSettingActivity";
    ListView mainMenuView;
    String[] menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        setContentView(R.layout.activity_house_setting);
        Resources resources = getResources();
        menuList = resources.getStringArray(R.array.main_menu_array);
        mainMenuView = (ListView) findViewById(R.id.mainMenuView);
        mainMenuView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuList));
        mainMenuView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(ACTIVITY_NAME, "User clicked a menu item");
                Toast.makeText(getApplicationContext(), menuList[position], Toast.LENGTH_SHORT).show();
                if (menuList[position].equals("Garage")){
                    Intent intent = new Intent(HouseSettingActivity.this, GarageActivity.class);
                    startActivityForResult(intent, 5);
                } else if (menuList[position].equals("House Temperature")){
                    Intent intent = new Intent(HouseSettingActivity.this, HouseTempActivity.class);
                    startActivityForResult(intent, 5);
                } else if (menuList[position].equals("Outside Weather")){
                    Intent intent = new Intent(HouseSettingActivity.this, OutsideTempActivity.class);
                    startActivityForResult(intent, 5);
                }

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
