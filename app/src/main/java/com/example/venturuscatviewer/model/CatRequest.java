package com.example.venturuscatviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CatRequest {

    private String id;

    private String title;

    private String link;

    @SerializedName("images")
    private List<ImageRequest> imageRequestList = new ArrayList<>();

    public CatRequest() {
    }

    public CatRequest(String id, String title, String link, List<ImageRequest> imageRequestList) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.imageRequestList = imageRequestList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<ImageRequest> getImageRequestList() {
        return imageRequestList;
    }

    public void setImageRequestList(List<ImageRequest> imageRequestList) {
        this.imageRequestList = imageRequestList;
    }
}
