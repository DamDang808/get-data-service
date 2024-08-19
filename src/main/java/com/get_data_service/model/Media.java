package com.get_data_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "media")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Media implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String mediaName;
    private String description;
    private int views;
    private String type;
    private String tag;
    private int likes;
    private String imageUrl;
    private int duration;
    private String url;
    private String resolution;
    private int isDownloadable;
    private int priority;
    private int position;
    private String hashTag;
    private String source;
}
