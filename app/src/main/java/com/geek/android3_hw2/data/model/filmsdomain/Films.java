package com.geek.android3_hw2.data.model.filmsdomain;

import com.google.gson.annotations.SerializedName;

public class Films<ContentId,ContentTitle> {
    @SerializedName("id")
    private ContentId id;
    @SerializedName("title")
    private ContentTitle title;

    public Films(ContentId id, ContentTitle title) {
        this.id = id;
        this.title = title;
    }

    public ContentTitle getTitle() {
        return title;
    }

    public void setTitle(ContentTitle title) {
        this.title = title;
    }

    public ContentId getId() {
        return id;
    }

    public void setId(ContentId id) {
        this.id = id;
    }
}
