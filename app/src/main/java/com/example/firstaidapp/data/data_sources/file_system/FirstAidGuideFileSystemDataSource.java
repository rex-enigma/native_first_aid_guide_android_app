package com.example.firstaidapp.data.data_sources.file_system;

import android.content.Context;

import androidx.annotation.Nullable;

import com.example.firstaidapp.data.data_models.FirstAidGuide;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class FirstAidGuideFileSystemDataSource {
    private Context context;
    public FirstAidGuideFileSystemDataSource(Context context){
        this.context = context;
    }

    @Nullable
    private String loadJSONFromRawResource(String jsonFirstAidGuideFileName) {
        String json;
        try {
            int resourceId = context.getResources().getIdentifier(jsonFirstAidGuideFileName, "raw", context.getPackageName());
            InputStream is = context.getResources().openRawResource(resourceId);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public FirstAidGuide getFirstAidGuide(String jsonFirstAidGuideFileName){
        String json = loadJSONFromRawResource(jsonFirstAidGuideFileName);
        Gson gson = new Gson();
        return gson.fromJson(json, FirstAidGuide.class);
    }
}
