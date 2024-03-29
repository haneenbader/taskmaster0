package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

// target to button home page
        Button homePage = findViewById(R.id.tohomepage);
        //add eventListener
        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHomePage = new Intent(SettingsPage.this , MainActivity.class);
                startActivity(goToHomePage);
            }
        });



        Button save = findViewById(R.id.savesetting);
        // same as above
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(SettingsPage.this);
                SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();

                EditText editTextUserName = findViewById(R.id.edittextusername);
                String userName = editTextUserName.getText().toString();

                RadioButton team1 = findViewById(R.id.team1AddTask);
                RadioButton team2     = findViewById(R.id.team2AddTask);
                RadioButton team3      = findViewById(R.id.team3AddTask);

                if (team1.isChecked()){
                    sharedPreferencesEditor.putString("team", team1.getText().toString());
                }else if(team2.isChecked()){
                    sharedPreferencesEditor.putString("team", team2.getText().toString());
                }else if(team3.isChecked()){
                    sharedPreferencesEditor.putString("team", team3.getText().toString());
                }

                sharedPreferencesEditor.putString("userName", userName);
                sharedPreferencesEditor.apply();
            }
        });
    }


}