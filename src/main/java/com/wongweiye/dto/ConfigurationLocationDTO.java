package com.wongweiye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class ConfigurationLocationDTO {


    private Number id;
    private String code;
    private String title;
    private String description;
    private String deck;
    private String filename;
    private boolean status;
    private boolean overlap;
    private String comment;
    private String viewComment;

    public ConfigurationLocationDTO(Number number, String s, String s1, String s2, String s3, String s4, boolean equals, boolean equals1, String s5, String s6) {
        this.id =   number;
        this.code = s;
        this.title = s1;
        this.description = s2;
        this.deck = s3;
        this.filename = s4;
        this.status = equals;
        this.overlap = equals1;
        this.comment = s5;
        this.viewComment = s6;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isOverlap() {
        return overlap;
    }

    public void setOverlap(boolean overlap) {
        this.overlap = overlap;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getViewComment() {
        return viewComment;
    }

    public void setViewComment(String viewComment) {
        this.viewComment = viewComment;
    }
}
