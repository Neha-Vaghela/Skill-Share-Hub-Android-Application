package com.skillsharehub.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import com.skillsharehub.Adapter.FeedbackAdapter;
import com.skillsharehub.Model.FeedbackModel;
import com.skillsharehub.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView feedack;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private ArrayList<FeedbackModel> list;

    public HomeFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 1. Inflate the layout and store it in a View variable
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        // 2. Use the 'view' variable to find your IDs
        CircularProgressIndicator circularStreak =
                view.findViewById(R.id.circularStreak);

        feedack = view.findViewById(R.id.feedback);
        list = new ArrayList<>();
        list.add(new FeedbackModel(
                "Sneha Gupta",
                "Computer Science",
                "As a first-year student, this app helped me find senior mentors and quality resources instantly. The interface is so smooth and beautiful!",
                "Jan 2025"));

        list.add(new FeedbackModel(
                "Rahul Sharma",
                "Information Technology",
                "Amazing UI and very helpful resources.",
                "Feb 2025"));

        list.add(new FeedbackModel(
                "Aman Patel",
                "Mechanical Engineering",
                "Best learning platform for students.",
                "Mar 2025"));

        list.add(new FeedbackModel(
                "Riya Shah",
                "Civil Engineering",
                "Loved the community support.",
                "Apr 2025"));

        list.add(new FeedbackModel(
                "Krishna",
                "Computer Engineering",
                "Highly recommended for freshers.",
                "May 2025"));

        FeedbackAdapter adapter =
                new FeedbackAdapter(requireContext(), list);

        feedack.setLayoutManager(
                new LinearLayoutManager(requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false));

        feedack.setAdapter(adapter);

        // Makes RecyclerView behave like ViewPager
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(feedack);



        LinearLayoutManager manager =
                (LinearLayoutManager) feedack.getLayoutManager();

        runnable = new Runnable() {
            @Override
            public void run() {

                int current = manager.findFirstVisibleItemPosition();

                if (current == RecyclerView.NO_POSITION) {
                    handler.postDelayed(this, 3000);
                    return;
                }

                if (current == list.size() - 1) {
                    feedack.smoothScrollToPosition(0);
                } else {
                    feedack.smoothScrollToPosition(current + 1);
                }

                handler.postDelayed(this, 3000);
            }
        };

        handler.postDelayed(runnable, 3000);


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
    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (runnable != null) {
            handler.postDelayed(runnable, 3000);
        }
    }
}
