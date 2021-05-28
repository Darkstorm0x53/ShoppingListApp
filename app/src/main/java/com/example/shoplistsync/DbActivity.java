package com.example.shoplistsync;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class DbActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Toolbar toolbar;
    private DrawerLayout drawer;
    NavigationView navigationView;
    MainActivity mainActivityInst;
    Intent intent;
    ListView listView;

    //Button btnConfirm = (Button) findViewById(R.id.btnConfirmItemEntry);



    @Override
    public void onBackPressed()
    {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            this.moveTaskToBack(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_db);
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawer, toolbar, R.string.open_nav_drawer, R.string.close_nav_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        DbHandler dbHandler = new DbHandler(DbActivity.this);
      //  ArrayList<HashMap<String, String>> itemList = dbHandler.getList();

        //ListAdapter adapter = new SimpleAdapter(DbActivity.this,
          //      itemList, R.layout.db_list_item,
            //    new String[]{"id", "item", "info", "qty"},
              //  new int[]{R.id.item_id, R.id.item_name, R.id.item_info, R.id.item_qty});
        //listView.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.nav_add:
                Toast.makeText(this,"add selected", Toast.LENGTH_SHORT).show();
                add();
                break;
            case R.id.nav_edit:
                Toast.makeText(this,"edit selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_del:
                Toast.makeText(this,"delete selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this,"share shopping list", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                Toast.makeText(this,"Logged Out", Toast.LENGTH_SHORT).show();
                terminate();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void terminate()
    {
        intent = new Intent(DbActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void add()
    {
        intent = new Intent(DbActivity.this, AddItem.class);
        startActivity(intent);
    }

}