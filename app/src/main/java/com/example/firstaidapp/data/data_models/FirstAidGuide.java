package com.example.firstaidapp.data.data_models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirstAidGuide {
    private int id;
    // the image is a relative path (just the name of the image file)
    @Nullable
    private String image;
    private String condition;
    private FirstAidStep[] firstAidSteps;

    public FirstAidGuide(int id, @Nullable String image, String condition, FirstAidStep[] firstAidSteps) {
        this.id = id;
        this.image = image;
        this.condition = condition;
        this.firstAidSteps = firstAidSteps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage( @Nullable String image) {
        this.image = image;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public FirstAidStep[] getFirstAidSteps() {
        return firstAidSteps;
    }

    public void setFirstAidSteps(FirstAidStep[] firstAidSteps) {
        this.firstAidSteps = firstAidSteps;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id).append("\n");
        sb.append("condition: ").append(condition).append("\n");

        if (image != null) {
            sb.append("Image: ").append(image).append("\n");
        }else {
            sb.append("null\n");
        }

        sb.append("First Aid Steps:\n");
        for (FirstAidStep step : firstAidSteps) {
            sb.append("- ").append(step.toString()).append("\n");
        }
        return sb.toString();
    }
}
