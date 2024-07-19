package com.example.firstaidapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstaidapp.R;
import com.example.firstaidapp.adapters.GridViewAdapter;

public class GridViewActivity extends AppCompatActivity {

    GridView gridView;

    String[] titles ={
            "fever", "nosebleed", "splinter", "choking", "food poisoning", "sprain",
            "dog bite", "hand cut", "insect bite", "frostbite", "minor burn", "major burn",
    };

    int[] images = {
            R.mipmap.fever,R.mipmap.nosebleed,R.mipmap.splinter,
            R.mipmap.choking,R.mipmap.food_poisoning,R.mipmap.sprain,
            R.mipmap.dog_bite,R.mipmap.hand_cut,R.mipmap.insect_bite,
            R.mipmap.frostbite,R.mipmap.minor_burn,R.mipmap.major_burn,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_activity);

        gridView = findViewById(R.id.gridView);
        GridViewAdapter gridAdapter = new GridViewAdapter(this, titles, images);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(GridViewActivity.this, FirstAidGuideViewActivity.class);
            intent.putExtra("gridItemTitle",titles[position]);
            startActivity(intent);

        });
    }
}
