package com.example.citygym;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.citygym.databinding.FragmentLoginBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.citygym.databinding.ActivityMainBinding;
import com.example.citygym.databinding.FragmentLoginBinding;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentLoginBinding binding;
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void showQR(View view){
        ImageView QRBig = findViewById(R.id.QRViewBig);
        QRBig.setVisibility(View.VISIBLE);
        ImageView QR = findViewById(R.id.QRView);
        QR.setVisibility(View.GONE);
        ImageView Logo = findViewById(R.id.AppLogo);
        Logo.setVisibility(View.GONE);
        ImageView Avatar = findViewById(R.id.Avatar);
        Avatar.setVisibility(View.GONE);
    }

    public void hideQR(View view){
        ImageView QRBig = findViewById(R.id.QRViewBig);
        QRBig.setVisibility(View.GONE);
        ImageView QR = findViewById(R.id.QRView);
        QR.setVisibility(View.VISIBLE);
        ImageView Logo = findViewById(R.id.AppLogo);
        Logo.setVisibility(View.VISIBLE);
        ImageView Avatar = findViewById(R.id.Avatar);
        Avatar.setVisibility(View.VISIBLE);
    }
    public void login(View view){
        ActivityMainBinding binding;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_login, R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void show_data_panel(View view){
        ImageView QR = findViewById(R.id.QRView);
        QR.setVisibility(View.INVISIBLE);
        ImageView Avatar = findViewById(R.id.Avatar);
        Avatar.setVisibility(View.INVISIBLE);
    }
}