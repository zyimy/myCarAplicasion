package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class Marcas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ImageView bmw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcas);

        bmw = findViewById(R.id.imgWolvagen);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nvView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenedorMenu, new FragmentInicio());
        fragmentTransaction.commit();
        navigationView.setItemIconTintList(null);

        setTitle("Inicio");

        navigationView.setNavigationItemSelectedListener(this);
    }

    public void marcaCoche(View view){
        Intent intent = new Intent(Marcas.this.getBaseContext(),MarcaCoche.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item) {

        switch (item.getItemId()){
            case R.id.MenuInicio:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorMenu, new FragmentInicio());
                fragmentTransaction.commit();

                break;

            case R.id.menuBuscarCoche:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorMenu, new FragmentMarcas());
                fragmentTransaction.commit();

                break;

            case R.id.menuCompararCoche:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorMenu, new FragmentComparar());
                fragmentTransaction.commit();

                break;

            case R.id.menuCompararDepreciacion:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorMenu, new FragmentDepreciacion());
                fragmentTransaction.commit();

                break;


        }

        setTitle(item.getTitle());

        drawerLayout.closeDrawer(GravityCompat.START);



        return true;
    }
}