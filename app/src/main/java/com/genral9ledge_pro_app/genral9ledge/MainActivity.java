package com.genral9ledge_pro_app.genral9ledge;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.genral9ledge_pro_app.genral9ledge.Fragments.DeveloperFragment;
import com.genral9ledge_pro_app.genral9ledge.Fragments.cheap_ministerFragment;
import com.genral9ledge_pro_app.genral9ledge.Fragments.pradhan_mantriFragment;
import com.genral9ledge_pro_app.genral9ledge.Fragments.privacyFragment;
import com.genral9ledge_pro_app.genral9ledge.Fragments.purvPradhanmatriFragment;
import com.genral9ledge_pro_app.genral9ledge.Fragments.rajyaPalFragment;
import com.genral9ledge_pro_app.genral9ledge.Fragments.rajya_rajdhaniFragment;
import com.genral9ledge_pro_app.genral9ledge.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        setContentView(binding.getRoot());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);

        pradhan_mantriFragment developerFragment = new pradhan_mantriFragment();
        binding.toolbaName.setText(getString(R.string.pradhanmantri));
        loadFragments(developerFragment);

        drawerLayout.closeDrawer(GravityCompat.START);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_pradhan_mantri:

                        binding.toolbaName.setText(getString(R.string.pradhanmantri));
                        pradhan_mantriFragment developerFragment = new pradhan_mantriFragment();
                        loadFragments(developerFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                    case R.id.nav_cheap_minister:
                        binding.toolbaName.setText(getString(R.string.mukhyamantri));
                        cheap_ministerFragment cheap_ministerFragment = new cheap_ministerFragment();
                        loadFragments(cheap_ministerFragment);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_rajya_rajdhani:
                        binding.toolbaName.setText(getString(R.string.rajya_rajdhani));
                        rajya_rajdhaniFragment rajya_rajdhaniFragment1 = new rajya_rajdhaniFragment();
                        loadFragments(rajya_rajdhaniFragment1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_purvPradhanmatri:
                        binding.toolbaName.setText(getString(R.string.purv_prdhanmantri));
                        purvPradhanmatriFragment purvPradhan = new purvPradhanmatriFragment();
                        loadFragments(purvPradhan);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_rajyaPal:
                        binding.toolbaName.setText(getString(R.string.raj_rajpal));
                        rajyaPalFragment developerFragmentt = new rajyaPalFragment();
                        loadFragments(developerFragmentt);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.shareApp:
                        try {
                            Intent i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
                            String sAux = "\nLet me recommend you this application\n\n";
                            sAux = sAux + "https://play.google.com/store/apps/details?id=" + getPackageName(); // here define package name of you app
                            i.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(i, "choose one"));
                        } catch (Exception e) {
                            Log.e(">>>", "Error: " + e);
                        }
                        break;

                    case R.id.privacy_policy:
                        binding.toolbaName.setText("गोपनीयता नीति");
                        privacyFragment privacyFragmentt = new privacyFragment();
                        loadFragments(privacyFragmentt);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.rateUs:
                        Uri uri = Uri.parse("market://details?id=" + getPackageName());
                        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        try {
                            startActivity(goToMarket);
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                        }
                        break;
                    case R.id.nav_developer:
                        binding.toolbaName.setText("डेवलपर प्रोफाइल");
                        DeveloperFragment developerFragmenttt = new DeveloperFragment();
                        loadFragments(developerFragmenttt);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }
                return true;
            }
        });
    }

    private void loadFragments(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            //           drawerLayout.closeDrawer(navigationView);
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            finish();
        }
    }
}