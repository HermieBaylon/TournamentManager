package edu.uw.tcss450.tournamentmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.uw.tcss450.tournamentmanager.Data.DataFragment;
import edu.uw.tcss450.tournamentmanager.PastTournament.NewTournamentFragment;
import edu.uw.tcss450.tournamentmanager.PastTournament.PastTournamentFragment;
import edu.uw.tcss450.tournamentmanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Fragment menuFragment = new NewTournamentFragment();
//        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
//        t.replace(R.id.fragment_container, menuFragment);
//        t.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new NewTournamentFragment()).commit();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setSelectedItemId(R.id.nav_create_new_tournament);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_create_new_tournament:
                            selectedFragment = new NewTournamentFragment();
                            break;
                        case R.id.nav_view_past_tournament:
                            selectedFragment = new PastTournamentFragment();
                            break;
                        case R.id.nav_view_data:
                            selectedFragment = new DataFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

}