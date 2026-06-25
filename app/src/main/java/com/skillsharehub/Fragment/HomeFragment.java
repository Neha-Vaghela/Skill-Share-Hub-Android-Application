package com.skillsharehub.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import com.skillsharehub.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 1. Inflate the layout and store it in a View variable
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // 2. Use the 'view' variable to find your IDs
        CircularProgressIndicator circularStreak =
                view.findViewById(R.id.circularStreak);

        // 3. Set your data
        int currentStreak = 14;
        int goal = 30;

        if (circularStreak != null) {
            circularStreak.setMax(goal);
            circularStreak.setProgress(currentStreak);
        }


        // 4. Return the view
        return view;
    }
}
