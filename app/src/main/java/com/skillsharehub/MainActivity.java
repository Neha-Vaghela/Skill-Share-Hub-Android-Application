package com.skillsharehub;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.skillsharehub.Fragment.CommunityFragment;
import com.skillsharehub.Fragment.HomeFragment;
import com.skillsharehub.Fragment.ProfileFragment;
import com.skillsharehub.Fragment.ProjectFragment;
import com.skillsharehub.Fragment.ResourceFragment;
import com.skillsharehub.FunctionalFragment.FeedbackFragment;
import com.skillsharehub.FunctionalFragment.ShareResourceFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFrag(new HomeFragment(),false);
        bnview= findViewById(R.id.bnview);
        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.home) {
                    loadFrag(new HomeFragment(), false);
                } else if (id == R.id.resources) {
//                    loadFrag(new ResourceFragment(), true);
                    loadFrag(new FeedbackFragment(),true);
                } else if (id == R.id.project) {
                    loadFrag(new ProjectFragment(), true);
                } else if (id == R.id.community) {
                    loadFrag(new ShareResourceFragment(), true);
                } else if (id == R.id.profile) {
                    loadFrag(new ProfileFragment(),true);
                }
                return true;
            }

        });

    }
    public void loadFrag (Fragment fragment,boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}