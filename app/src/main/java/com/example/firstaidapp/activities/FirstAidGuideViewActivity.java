package com.example.firstaidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.firstaidapp.R;
import com.example.firstaidapp.adapters.FirstAidGuideViewAdapter;
import com.example.firstaidapp.data.data_models.FirstAidGuide;
import com.example.firstaidapp.data.data_sources.file_system.FirstAidGuideFileSystemDataSource;

public class FirstAidGuideViewActivity extends  AppCompatActivity{
    private ImageView conditionImage;
    private TextView conditionName;
    private ListView stepsListView;
    private FirstAidGuideViewAdapter firstAidGuideViewAdapter;

    FirstAidGuide firstAidGuide;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_aid_guide_view_activity);

        conditionImage = findViewById(R.id.condition_image);
        conditionName = findViewById(R.id.condition_name);
        stepsListView = findViewById(R.id.steps_list_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String gridItemTitle = intent.getStringExtra("gridItemTitle");

        FirstAidGuideFileSystemDataSource firstAidGuideFileSystemDataSource = new FirstAidGuideFileSystemDataSource(this);
        String jsonFirstAidGuideFileName =  getJsonFirstAidGuideFileName(gridItemTitle);
        firstAidGuide = firstAidGuideFileSystemDataSource.getFirstAidGuide(jsonFirstAidGuideFileName);
        Log.d("firstAidGuide", firstAidGuide.toString());

        conditionName.setText(firstAidGuide.getCondition());
        setConditionImage(conditionImage);
        firstAidGuideViewAdapter = new FirstAidGuideViewAdapter(this, firstAidGuide.getFirstAidSteps());
        stepsListView.setAdapter(firstAidGuideViewAdapter);

    }

    private void setConditionImage(ImageView conditionImage){
        if (firstAidGuide.getImage() != null) {
            int imageResId = getResources().getIdentifier(firstAidGuide.getImage(), "drawable", getPackageName());
            conditionImage.setImageResource(imageResId);
        }
        else{
            conditionImage.setVisibility(View.GONE);
        }
    }


    private String getJsonFirstAidGuideFileName(String gridItemTitle) {
        switch (gridItemTitle){
            case "fever":
                return "first_aid_guide_fever";
            case "nosebleed" :
                return "first_aid_guide_nosebleed";
            case "splinter":
                return "first_aid_guide_splinter";
            case "choking" :
                return "first_aid_guide_chocking";
            case "food poisoning":
                return "first_aid_guide_food_poisoning";
            case "sprain" :
                return "first_aid_guide_sprain";
            case "dog bite":
                return "first_aid_guide_dog_bite";
            case "hand cut" :
                return "first_aid_guide_minor_cut";
            case "insect bite":
                return "first_aid_guide_insect_bite";
            case "frostbite" :
                return "first_aid_guide_frostbite";
            case "minor burn":
                return "first_aid_guide_minor_burn";
            case "major burn" :
                return "first_aid_guide_major_burn";
            default:
                throw new RuntimeException("A grid item title should be provided");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Handle the back button click
        if (id == android.R.id.home) {
            finish(); // Navigate back to the previous activity
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

