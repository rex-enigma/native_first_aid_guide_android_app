package com.example.firstaidapp.data.data_models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FirstAidStep {
    private int stepNumber;
    private String title;
    @Nullable
    private String stepImage;
    private String description;

    // Constructor
    public FirstAidStep(int stepNumber, String title, @Nullable String stepImage, String description) {
        this.stepNumber = stepNumber;
        this.title = title;
        this.stepImage = stepImage;
        this.description = description;
    }


    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getStepImage() {
        return stepImage;
    }

    public void setStepImage(@Nullable String stepImage) {
        this.stepImage = stepImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @NonNull
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Step Number: ").append(stepNumber).append("\n");
        builder.append("Title: ").append(title).append("\n");

        builder.append("Image: ");
        if (stepImage != null) {
            builder.append(stepImage).append("\n");
        } else {
            builder.append("null\n");
        }
        builder.append("Description: ").append(description).append("\n");
        return builder.toString();
    }
}
