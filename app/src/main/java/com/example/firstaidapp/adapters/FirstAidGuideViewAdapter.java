package com.example.firstaidapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstaidapp.R;
import com.example.firstaidapp.data.data_models.FirstAidStep;

public class FirstAidGuideViewAdapter extends BaseAdapter {
    private Context context;
    private FirstAidStep[] firstAidSteps;

    private FirstAidStep firstAidStep;
    public FirstAidGuideViewAdapter(Context context, FirstAidStep[] firstAidSteps){
        this.context = context;
        this.firstAidSteps = firstAidSteps;
    }


    @Override
    public int getCount() {
        return firstAidSteps.length;
    }

    @Override
    public Object getItem(int position) {
        return firstAidSteps[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a list view item for the list view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem;
        firstAidStep = (FirstAidStep) getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listViewItem = inflater.inflate(R.layout.list_view_item, null);

            TextView stepTitle =  listViewItem.findViewById(R.id.step_title);
            ImageView stepImage = listViewItem.findViewById(R.id.step_image);
            TextView stepDescription = listViewItem.findViewById(R.id.step_description);


            stepTitle.setText(new StringBuilder().append("Step ").append(firstAidStep.getStepNumber()).append(": ").append(firstAidStep.getTitle()).toString());
            stepDescription.setText(firstAidStep.getDescription());
            setStepImage(stepImage);

        return listViewItem;
    }


    private void setStepImage(ImageView stepImage){
        if (firstAidStep.getStepImage() != null) {
            int imageResId = context.getResources().getIdentifier(firstAidStep.getStepImage(), "drawable", context.getPackageName());
            stepImage.setImageResource(imageResId);
        }
        else{
            stepImage.setVisibility(View.GONE);
        }
    }
}
