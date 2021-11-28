package com.example.citygym;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.citygym.databinding.FragmentLoginBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.citygym.databinding.ActivityMainBinding;
import com.example.citygym.databinding.FragmentLoginBinding;

import org.w3c.dom.Text;


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
        TextView UserName = findViewById((R.id.UsernameView));
        UserName.setVisibility((View.VISIBLE));
        TextView PasswordView = findViewById(R.id.PasswordView);
        PasswordView.setVisibility((View.VISIBLE));
        TextView EmailView = findViewById(R.id.emailView);
        EmailView.setVisibility(View.VISIBLE);
        TextView SubId = findViewById(R.id.SubscriptionID);
        SubId.setVisibility(View.VISIBLE);
        TextView SubEnd = findViewById(R.id.SubscriptionEnd);
        SubEnd.setVisibility(View.VISIBLE);
        Button ChangePass = findViewById(R.id.ChangePassword);
        ChangePass.setVisibility(View.VISIBLE);
    }

    public void change_password (View view){
        TextView UserName = findViewById(R.id.UsernameView);
        UserName.setVisibility(View.INVISIBLE);
        TextView PasswordView = findViewById(R.id.PasswordView);
        PasswordView.setVisibility(View.INVISIBLE);
        TextView EmailView = findViewById(R.id.emailView);
        EmailView.setVisibility(View.INVISIBLE);
        TextView SubId = findViewById(R.id.SubscriptionID);
        SubId.setVisibility(View.INVISIBLE);
        TextView SubEnd = findViewById(R.id.SubscriptionEnd);
        SubEnd.setVisibility(View.INVISIBLE);
        Button ChangePass = findViewById(R.id.ChangePassword);
        ChangePass.setVisibility(View.INVISIBLE);
        TextView OldPass = findViewById(R.id.OldPassword);
        OldPass.setVisibility(View.VISIBLE);
        TextView NewPass = findViewById(R.id.NewPassword);
        NewPass.setVisibility(View.VISIBLE);
        TextView RepNewPass = findViewById(R.id.RepeatNewPassword);
        RepNewPass.setVisibility(View.VISIBLE);
        EditText GiveOldPassword = findViewById(R.id.GiveOldPassword);
        GiveOldPassword.setVisibility(View.VISIBLE);
        EditText GiveNewPassword = findViewById(R.id.GiveNewPassword);
        GiveNewPassword.setVisibility(View.VISIBLE);
        EditText GiveRepeatNewPassword = findViewById(R.id.GiveRepeatNewPassword);
        GiveRepeatNewPassword.setVisibility(View.VISIBLE);
        Button Change = findViewById(R.id.change);
        Change.setVisibility(View.VISIBLE);
    }

    public void accept (View view) {
        TextView UserName = findViewById((R.id.UsernameView));
        UserName.setVisibility((View.VISIBLE));
        TextView PasswordView = findViewById(R.id.PasswordView);
        PasswordView.setVisibility((View.VISIBLE));
        TextView EmailView = findViewById(R.id.emailView);
        EmailView.setVisibility(View.VISIBLE);
        TextView SubId = findViewById(R.id.SubscriptionID);
        SubId.setVisibility(View.VISIBLE);
        TextView SubEnd = findViewById(R.id.SubscriptionEnd);
        SubEnd.setVisibility(View.VISIBLE);
        Button ChangePass = findViewById(R.id.ChangePassword);
        ChangePass.setVisibility(View.VISIBLE);
        TextView OldPass = findViewById(R.id.OldPassword);
        OldPass.setVisibility(View.GONE);
        TextView NewPass = findViewById(R.id.NewPassword);
        NewPass.setVisibility(View.GONE);
        TextView RepNewPass = findViewById(R.id.RepeatNewPassword);
        RepNewPass.setVisibility(View.GONE);
        EditText GiveOldPassword = findViewById(R.id.GiveOldPassword);
        GiveOldPassword.setVisibility(View.GONE);
        EditText GiveNewPassword = findViewById(R.id.GiveNewPassword);
        GiveNewPassword.setVisibility(View.GONE);
        EditText GiveRepeatNewPassword = findViewById(R.id.GiveRepeatNewPassword);
        GiveRepeatNewPassword.setVisibility(View.GONE);
        Button Change = findViewById(R.id.change);
        Change.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Haslo zostalo zmienione!", Toast.LENGTH_SHORT).show();
    }
}