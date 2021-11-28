package com.example.citygym;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.citygym.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

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
        TextView Login_Text = findViewById(R.id.Login_text);
        Login_Text.setVisibility(View.GONE);
        TextView Login_Input = findViewById(R.id.Login_Input);
        Login_Input.setVisibility(View.GONE);
        TextView Password_Text = findViewById(R.id.Password_text);
        Password_Text.setVisibility(View.GONE);
        TextView Password_Input = findViewById(R.id.Password_Input);
        Password_Input.setVisibility(View.GONE);
        View Login_Button = findViewById(R.id.Login_button);
        Login_Button.setVisibility(View.GONE);
        ImageView QR = findViewById(R.id.QRView);
        QR.setVisibility(View.VISIBLE);
        ImageView Avatar = findViewById(R.id.Avatar);
        Avatar.setVisibility(View.VISIBLE);
    }
}