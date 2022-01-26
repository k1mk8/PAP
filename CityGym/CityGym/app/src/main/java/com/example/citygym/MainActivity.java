package com.example.citygym;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.citygym.databinding.ActivityMainBinding;
import com.example.citygym.databinding.FragmentLoginBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import login.LoginModule;
import login.QRGenerator;


public class MainActivity extends AppCompatActivity {

    private boolean logged_in;
    private boolean isTrainer;

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

    public void registerShow(View view) {
        View Login = findViewById(R.id.loginLayout);
        Login.setVisibility(View.INVISIBLE);
        View Register = findViewById(R.id.registerLayout);
        Register.setVisibility(View.VISIBLE);
        TextView login = findViewById(R.id.Login_Input);
        TextView loginRegister = findViewById(R.id.Login_Input_register);
        loginRegister.setText(login.getText());
        TextView passsword = findViewById(R.id.Password_Input);
        TextView passwordRegister = findViewById(R.id.Password_Input_register);
        passwordRegister.setText(passsword.getText());
        Login = findViewById(R.id.registerLayout2);
        Login.setVisibility(View.INVISIBLE);
    }

    public void registerShow2(View view) {
        View Login = findViewById(R.id.registerLayout);
        Login.setVisibility(View.INVISIBLE);
        View Register = findViewById(R.id.registerLayout2);
        Register.setVisibility(View.VISIBLE);
        Login = findViewById(R.id.registerLayout3);
        Login.setVisibility(View.INVISIBLE);
    }

    public void registerShow3(View view) {
        View Login = findViewById(R.id.registerLayout2);
        Login.setVisibility(View.INVISIBLE);
        View Register = findViewById(R.id.registerLayout3);
        Register.setVisibility(View.VISIBLE);
        Login = findViewById(R.id.registerLayout4);
        Login.setVisibility(View.INVISIBLE);
    }

    public void registerShow4(View view) {
        View Login = findViewById(R.id.registerLayout3);
        Login.setVisibility(View.INVISIBLE);
        View Register = findViewById(R.id.registerLayout4);
        Register.setVisibility(View.VISIBLE);
        Login = findViewById(R.id.registerLayout5);
        Login.setVisibility(View.INVISIBLE);
    }

    public void registerShow5(View view) {
        View Login = findViewById(R.id.registerLayout4);
        Login.setVisibility(View.INVISIBLE);
        View Register = findViewById(R.id.registerLayout5);
        Register.setVisibility(View.VISIBLE);
    }

    public void register(View view) {
        String country;
        String city;
        String postcode;
        String street;
        String buildingNumber;
        String streetNumber;
        int region;
        String name;
        String surname;
        int pesel;
        String date;
        String login;
        String password;
        String email;

        TextView dataView;

        dataView = findViewById(R.id.Login_Input_register);
        login = dataView.getText().toString();
        dataView = findViewById(R.id.Password_Input_register);
        password = dataView.getText().toString();
        dataView = findViewById(R.id.email_Input_register);
        email = dataView.getText().toString();
        dataView = findViewById(R.id.name_Input_register);
        name = dataView.getText().toString();
        dataView = findViewById(R.id.surname_Input_register);
        surname = dataView.getText().toString();
        dataView = findViewById(R.id.pesel_Input_register);
        pesel = Integer.parseInt(dataView.getText().toString());
        dataView = findViewById(R.id.date_Input_register);
        date = dataView.getText().toString();
        dataView = findViewById(R.id.country_Input_register);
        country = dataView.getText().toString();
        dataView = findViewById(R.id.region_Input_register);
        region = Integer.parseInt(dataView.getText().toString());
        dataView = findViewById(R.id.city_Input_register);
        city = dataView.getText().toString();
        dataView = findViewById(R.id.postcode_Input_register);
        postcode = dataView.getText().toString();
        dataView = findViewById(R.id.street_Input_register);
        street = dataView.getText().toString();
        dataView = findViewById(R.id.streetnumber_Input_register);
        streetNumber = dataView.getText().toString();
        dataView = findViewById(R.id.buildingnumber_Input_register);
        buildingNumber = dataView.getText().toString();

        if(LoginModule.register(country, city,postcode, street, buildingNumber,
                streetNumber, region, name, surname, pesel, date, login, password, email)){
            Toast.makeText(getApplicationContext(), "Registration completed", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Registration unsuccessful", Toast.LENGTH_LONG).show();
        }
    }

    public void back(View view) {
        View Login = findViewById(R.id.loginLayout);
        Login.setVisibility(View.VISIBLE);
        View Register = findViewById(R.id.registerLayout);
        Register.setVisibility(View.INVISIBLE);
    }

    public void login(View view){

        requestPermissions(new String[] { Manifest.permission.INTERNET }, 1);


        TextView GetText = findViewById(R.id.Login_Input);
        String login = GetText.getText().toString();
        GetText = findViewById(R.id.Password_Input);
        String password = GetText.getText().toString();
        Context context = getApplicationContext();
        logged_in = LoginModule.authenticate(login, password);

        CharSequence text;
        int duration = Toast.LENGTH_SHORT;
        if(logged_in){
            isTrainer = LoginModule.getTrainer();
            ActivityMainBinding binding;
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            BottomNavigationView navView = findViewById(R.id.nav_view);
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                @Override
                public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                    if (destination.getId() == R.id.navigation_home) {
                        if(isTrainer){
                            navController.navigate(R.id.navigation_home_trainers);
                        }
                    }
                    if (destination.getId() == R.id.navigation_notifications) {
                        if(isTrainer){
                            navController.navigate(R.id.navigation_home_trainers);
                            Toast.makeText(getApplicationContext(), "Shop for staff is still to be released", Toast.LENGTH_LONG).show();

                        }
                    }
                }
            });
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.navigation_login, R.id.navigation_home, R.id.navigation_home_trainers, R.id.navigation_dashboard, R.id.navigation_notifications)
                    .build();
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
            NavigationUI.setupWithNavController(binding.navView, navController);

            text = "Logged in";
        }
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

    public void changePassword(View view){
        View Info_Layout = findViewById(R.id.Info_Layout);
        Info_Layout.setVisibility(View.GONE);
        View Change_password_layout = findViewById(R.id.Change_password_layout);
        Change_password_layout.setVisibility(View.VISIBLE);
    }

    public void accept(View view) {
        View Info_Layout = findViewById((R.id.Info_Layout));
        Info_Layout.setVisibility((View.VISIBLE));
        View Change_password_layout = findViewById(R.id.Change_password_layout);
        Change_password_layout.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "Password has been changed!", Toast.LENGTH_SHORT).show();
    }

    public void eventManagement(View view){
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.navigation_events);
    }

    public void buy1(View view){
        Toast.makeText(getApplicationContext(), "Thanks!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "You've just bought a pass for a month!", Toast.LENGTH_LONG).show();
    }

    public void buy2(View view){
        Toast.makeText(getApplicationContext(), "Thanks!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "You've just bought a pass for three months!", Toast.LENGTH_LONG).show();
    }

    public void buy3(View view){
        Toast.makeText(getApplicationContext(), "Thanks!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "You've just bought a pass for six months!", Toast.LENGTH_LONG).show();
    }

    public void buy4(View view){
        Toast.makeText(getApplicationContext(), "Thanks!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "You've just bought a pass for a year!", Toast.LENGTH_LONG).show();
    }
}