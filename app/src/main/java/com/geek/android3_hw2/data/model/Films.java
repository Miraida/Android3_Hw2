package com.geek.android3_hw2.data.model;
import com.google.gson.annotations.SerializedName;

public class Films {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;

    public Films(String id, String title) {
        this.id = id;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
