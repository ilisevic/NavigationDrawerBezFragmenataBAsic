package com.boilerplatecode.navigationdrawerbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
if (savedInstanceState==null) {
    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
}
        navigationView.setCheckedItem(R.id.nav_message);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {

            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment()).commit();
                break;
            case R.id.nav_message2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment2()).commit();

                break;
            case R.id.nav_message3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragment3()).commit();

                break;
            case R.id.nav_share:
                Toast.makeText(this,"tekst kliknuto share",Toast.LENGTH_LONG).show();
                break;

            case R.id.nav_send:
                Toast.makeText(this,"tekst kliknuto send " ,Toast.LENGTH_LONG).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {drawer.closeDrawer(GravityCompat.START);}
       else { super.onBackPressed();}
    }
}
