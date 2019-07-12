package com.anthesis.assignment.model;

import com.google.gson.annotations.SerializedName;

public class HighlightResult {

    @SerializedName("author")
    private Author author;

    @SerializedName("title")
    private Title title;

    @SerializedName("url")
    private Url url;

    @SerializedName("story_text")
    private StoryText storyText;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public StoryText getStoryText() {
        return storyText;
    }

    public void setStoryText(StoryText storyText) {
        this.storyText = storyText;
    }

    @Override
    public String toString() {
        return
                "HighlightResult{" +
                        "author = '" + author + '\'' +
                        ",title = '" + title + '\'' +
                        ",url = '" + url + '\'' +
                        ",story_text = '" + storyText + '\'' +
                        "}";
    }
}