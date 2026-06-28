package com.skillsharehub.FunctionalFragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.skillsharehub.Adapter.CategoryAdapter;
import com.skillsharehub.Model.CategoryModel;
import com.skillsharehub.R;

import java.util.ArrayList;

public class ShareResourceFragment extends Fragment {

    MaterialButton submitResource ;
    EditText link;
    RecyclerView resouceCategory ;
    private ArrayList<CategoryModel> categoryList;
    private CategoryAdapter categoryAdapter;
    LinearLayout youtube, pdf, github, ResouceLink,selectedLayout;

    TextView youtubeText, pdfText, githubText, ResourceeLinkText,subject;



    public ShareResourceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share_resource, container, false);

        submitResource = view.findViewById(R.id.submitResource);
        link = view.findViewById(R.id.link);
        resouceCategory = view.findViewById(R.id.resouceCategory);

        youtube = view.findViewById(R.id.youtube);
        pdf = view.findViewById(R.id.pdf);
        github = view.findViewById(R.id.github);
        ResouceLink = view.findViewById(R.id.ResouceLink);

        youtubeText=view.findViewById(R.id.youtubeText);
        pdfText=view.findViewById(R.id.pdfText);
        githubText=view.findViewById(R.id.githubText);
        ResourceeLinkText=view.findViewById(R.id.ResourceeLinkText);

        subject = view.findViewById(R.id.subject);

       selectedLayout = null;


        categoryList = new ArrayList<>();

        link.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submitResource.setEnabled(true);

            }
        });
        loadCategories();

        youtube.setOnClickListener(v ->
                selectCard(youtube, youtubeText,
                        R.drawable.bg_youtube,
                        Color.parseColor("#FF0000")));

        pdf.setOnClickListener(v ->
                selectCard(pdf, pdfText,
                        R.drawable.bg_youtube,
                        Color.parseColor("#FF0000")));

        github.setOnClickListener(v ->
                selectCard(github, githubText,
                        R.drawable.bg_github,
                        Color.parseColor("#2EC4B6")));

        ResouceLink.setOnClickListener(v ->
                selectCard(ResouceLink, ResourceeLinkText,
                        R.drawable.bg_link,
                        Color.parseColor("#3A86FF")));



        return view;
    }
    private void loadCategories() {

//        addCategory("All", true);
        addCategory("AI/ML", false);
        addCategory("Web Dev", false);
        addCategory("Android", true);
        addCategory("DSA", false);
        addCategory("Other", false);
        setupCategoryRecycler();

    }

    private void addCategory(String name, boolean selected) {

        categoryList.add(new CategoryModel(name, selected));

    }

    private void setupCategoryRecycler() {

        categoryAdapter = new CategoryAdapter(
                requireContext(),
                categoryList,
                selectedSubject -> subject.setText(selectedSubject)
        );

        resouceCategory.setLayoutManager(
                new LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false));

        resouceCategory.setAdapter(categoryAdapter);
    }

    private void resetAll() {

        resetCard(youtube, youtubeText);
        resetCard(pdf, pdfText);
        resetCard(github, githubText);
        resetCard(ResouceLink, ResourceeLinkText);

    }
    private void resetCard(LinearLayout layout, TextView text) {

        layout.setBackgroundResource(R.drawable.bg_white);
        text.setTextColor(Color.parseColor("#4A5568"));

    }
    private void selectCard(LinearLayout layout,
                            TextView text,
                            int background,
                            int textColor) {

        resetAll();

        layout.setBackgroundResource(background);
        text.setTextColor(textColor);

        selectedLayout = layout;
    }
}