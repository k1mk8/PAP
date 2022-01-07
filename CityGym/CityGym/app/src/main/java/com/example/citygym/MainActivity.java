package com.example.citygym;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.citygym.databinding.ActivityMainBinding;
import com.example.citygym.databinding.FragmentLoginBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import login.LoginModule;
import login.QRGenerator;


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
        QRGenerator.setImageQR("987654321", QRBig);
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

        requestPermissions(new String[] { Manifest.permission.INTERNET }, 1);


        TextView GetText = findViewById(R.id.Login_Input);
        String login = GetText.getText().toString();
        GetText = findViewById(R.id.Password_Input);
        String password = GetText.getText().toString();
        boolean logged_in = LoginModule.authenticate(login, password);
        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;
        if(logged_in){
            text = "Logged in";
            ActivityMainBinding binding;
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            BottomNavigationView navView = findViewById(R.id.nav_view);
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_login, R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(binding.navView, navController);
        }/*
        else if(logged_in == 2){
            text = "Logged in";
            ActivityMainBinding binding;
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            BottomNavigationView navView = findViewById(R.id.nav_view);
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_login, R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                    .build();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(binding.navView, navController);
        }*/
        else{
            text = "Check provided username and password";
        }
        Toast.makeText(context, text, duration).show();
    }

    public void show_data_panel(View view){
        ImageView QR = findViewById(R.id.QRView);
        QR.setVisibility(View.INVISIBLE);
        ImageView Avatar = findViewById(R.id.Avatar);
        Avatar.setVisibility(View.INVISIBLE);
        View Info_Layout = findViewById(R.id.Info_Layout);
        Info_Layout.setVisibility(View.VISIBLE);
    }

    public void change_password (View view){
        View Info_Layout = findViewById(R.id.Info_Layout);
        Info_Layout.setVisibility(View.GONE);
        View Change_password_layout = findViewById(R.id.Change_password_layout);
        Change_password_layout.setVisibility(View.VISIBLE);
    }

    public void accept (View view) {
        View Info_Layout = findViewById((R.id.Info_Layout));
        Info_Layout.setVisibility((View.VISIBLE));
        View Change_password_layout = findViewById(R.id.Change_password_layout);
        Change_password_layout.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Haslo zostalo zmienione!", Toast.LENGTH_SHORT).show();
    }
}