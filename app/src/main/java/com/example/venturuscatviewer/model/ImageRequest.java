package com.example.venturuscatviewer.model;

public class ImageRequest {

    private String id;

    private String type;

    private String link;


    public ImageRequest() {
    }

    public ImageRequest(String id, String type, String link) {
        this.id = id;
        this.type = type;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
