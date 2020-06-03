package com.laioffer.vicabulary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.vicabulary.database.DatabaseHelper;
import com.laioffer.vicabulary.database.VideoDatabase;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    DatabaseHelper videoDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Test test test
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    BottomNavigationView navView = findViewById(R.id.nav_view);
    NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
            .findFragmentById(R.id.nav_host_fragment);
    navController =navHostFragment.getNavController();
       NavigationUI.setupWithNavController(navView,navController);
       NavigationUI.setupActionBarWithNavController(this,navController);


       //video database
        videoDb = new DatabaseHelper((this));
        VideoDatabase.CreateDatabase(videoDb);

}

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

}

