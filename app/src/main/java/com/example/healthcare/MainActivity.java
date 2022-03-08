package com.example.healthcare;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationDrawerView;
    androidx.appcompat.widget.Toolbar toolbar;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setId();
        initialTask();
        setDrawer();

        // TODO: 07-03-2022 Fragment container adapter

        // On menu item click listener
        navigationDrawerView.setNavigationItemSelectedListener(item -> {
            onMenuItemSelectedByUser(item);
            return true;
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void onMenuItemSelectedByUser(MenuItem item) {
        // TODO: 07-03-2022 Other menu item listener
        switch (item.getItemId()) {
            case R.id.nav_logout: {
                logout();
            }
            break;
        }
    }

    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Logout")
                .setMessage("Are you sure that you want to logout?")
                .setPositiveButton("LOG OUT", (dialogInterface, i) -> {
//                    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//                    if (firebaseUser != null) {
//                        // That means current user is logged in so now we can continue to log out
//                        FirebaseAuth.getInstance().signOut();
//                        startActivity(new Intent(MainActivity.this, Login.class)
//                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
//                    }
                })
                .setNegativeButton("CANCEL", (dialogInterface, i) -> dialogInterface.dismiss())
                .create()
                .show();
    }

    private void setDrawer() {

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void initialTask() {
        setSupportActionBar(toolbar);
    }

    private void setId() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationDrawerView = findViewById(R.id.nvView);
        toolbar = findViewById(R.id.main_toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}








