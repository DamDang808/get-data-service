package com.get_data_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDTO implements Serializable {

    private String mediaName;
    private String description;
    private int views;
    private String type;
    private String tag;
    private int likes;
    private String imageUrl;
    private int duration;

    public void loadFromEntity(Media media) {
        this.mediaName = media.getMediaName();
        this.description = media.getDescription();
        this.views = media.getViews();
        this.type = media.getType();
        this.tag = media.getTag();
        this.likes = media.getLikes();
        this.imageUrl = media.getImageUrl();
        this.duration = media.getDuration();
    }
}
