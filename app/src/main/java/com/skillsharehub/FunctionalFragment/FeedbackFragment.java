package com.skillsharehub.FunctionalFragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
import com.google.android.material.card.MaterialCardView;
import com.skillsharehub.R;

public class FeedbackFragment extends Fragment {

    EditText feedback ;
    MaterialButton submitBtn;
    LinearLayout cardBug, cardFeature, cardGeneral,selectCard;
    ImageView iconBug , iconFeature, iconGeneral;
    TextView textBug , textFeature, textGeneral;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        feedback = view.findViewById(R.id.feedback);
        submitBtn = view.findViewById(R.id.submitBtn);

        cardBug =view.findViewById(R.id.cardBug);
        cardFeature=view.findViewById(R.id.cardFeature);
        cardGeneral=view.findViewById(R.id.cardGeneral);

        iconBug=view.findViewById(R.id.iconBug);
        iconFeature=view.findViewById(R.id.iconFeature);
        iconGeneral=view.findViewById(R.id.iconGeneral);

        textBug=view.findViewById(R.id.textBug);
        textFeature=view.findViewById(R.id.textFeature);
        textGeneral=view.findViewById(R.id.textGeneral);


        cardBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectCard == cardBug) {

                    resetCard(cardBug, iconBug, textBug);
                    selectCard = null;
                }else {
                    resetAllCards();
                    selectedCard(cardBug, iconBug, textBug);
                    selectCard = cardBug;
                }
            }
        });
        cardFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectCard == cardFeature) {

                    resetCard(cardFeature, iconFeature, textFeature);
                    selectCard = null;
                }else{
                    resetAllCards();
                    selectedCard(cardFeature,iconFeature,textFeature);
                    selectCard = cardFeature;
                }
            }
        });
        cardGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectCard == cardGeneral ){

                    resetCard(cardGeneral,iconGeneral,textGeneral);
                }else {
                    resetAllCards();
                    selectedCard(cardGeneral, iconGeneral, textGeneral);
                    selectCard = cardGeneral;
                }
            }
        });

        submitBtn.setEnabled(false);
        feedback.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {

            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submitBtn.setEnabled(true);
            }
        });



        return view;
    }
    public void selectedCard(LinearLayout selectedCard, ImageView selectedImg, TextView selectedText){
        selectedCard.setBackgroundColor(Color.parseColor("#2196F3"));
        selectedImg.setColorFilter(Color.WHITE);
        selectedText.setTextColor(Color.WHITE);
    }
    private void resetCard(LinearLayout card, ImageView image, TextView text) {

        card.setBackgroundColor(Color.WHITE);
        image.setColorFilter(Color.parseColor(("#797F86")));
        text.setTextColor(Color.parseColor("#797F86"));
    }
    private void resetAllCards() {
        resetCard(cardBug, iconBug, textBug);
        resetCard(cardFeature, iconFeature, textFeature);
        resetCard(cardGeneral, iconGeneral, textGeneral);
    }
}