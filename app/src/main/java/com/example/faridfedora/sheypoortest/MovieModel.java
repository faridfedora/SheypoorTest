package com.example.faridfedora.sheypoortest;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faridfedora on 2/23/17.
 */

public class MovieModel implements Parcelable {
    private int id;
//    private String url;
    private String name;
//    private String type;
//    private String language;
//    private ArrayList<String> genres;
//    private String status;
    private int runtime;
    private String premiered;
    private Map<String,String> rating;
    private Map<String,String> image;
    private String summary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public Map<String, String> getRating() {
        return rating;
    }

    public void setRating(Map<String, String> rating) {
        this.rating = rating;
    }

    public Map<String, String> getImage() {
        return image;
    }

    public void setImage(Map<String, String> image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    protected MovieModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        runtime = in.readInt();
        premiered = in.readString();
        summary = in.readString();

//        String mediumImage=in.readString();
//        String originalImage=in.readString();
//        image.put("medium",mediumImage);
//        image.put("original",originalImage);
//        String averageRating=in.readString();
//        rating.put("average",averageRating);


    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeInt(runtime);
            dest.writeString(premiered);
            dest.writeString(summary);

//            String mediumImage = image.get("medium");
//            dest.writeString(mediumImage);
//            String originalImage = image.get("original");
//            dest.writeString(originalImage);
//            String averageRating=rating.get("average");
//            dest.writeString(averageRating);


    }
}
