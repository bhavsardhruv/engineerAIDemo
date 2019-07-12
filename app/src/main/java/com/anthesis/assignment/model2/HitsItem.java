package com.anthesis.assignment.model2;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HitsItem {

    @SerializedName("comment_text")
    private Object commentText;

    @SerializedName("story_text")
    private Object storyText;

    @SerializedName("author")
    private String author;

    @SerializedName("story_id")
    private Object storyId;

    @SerializedName("_tags")
    private List<String> tags;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("created_at_i")
    private int createdAtI;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("points")
    private int points;

    @SerializedName("_highlightResult")
    private HighlightResult highlightResult;

    @SerializedName("num_comments")
    private int numComments;

    @SerializedName("story_title")
    private Object storyTitle;

    @SerializedName("parent_id")
    private Object parentId;

    @SerializedName("story_url")
    private Object storyUrl;

    @SerializedName("relevancy_score")
    private int relevancyScore;

    @SerializedName("objectID")
    private String objectID;

    private boolean isSelected=false;

    public Object getCommentText() {
        return commentText;
    }

    public void setCommentText(Object commentText) {
        this.commentText = commentText;
    }

    public Object getStoryText() {
        return storyText;
    }

    public void setStoryText(Object storyText) {
        this.storyText = storyText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getStoryId() {
        return storyId;
    }

    public void setStoryId(Object storyId) {
        this.storyId = storyId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedAtI() {
        return createdAtI;
    }

    public void setCreatedAtI(int createdAtI) {
        this.createdAtI = createdAtI;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public HighlightResult getHighlightResult() {
        return highlightResult;
    }

    public void setHighlightResult(HighlightResult highlightResult) {
        this.highlightResult = highlightResult;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public Object getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(Object storyTitle) {
        this.storyTitle = storyTitle;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public Object getStoryUrl() {
        return storyUrl;
    }

    public void setStoryUrl(Object storyUrl) {
        this.storyUrl = storyUrl;
    }

    public int getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(int relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    @Override
    public String toString() {
        return
                "HitsItem{" +
                        "comment_text = '" + commentText + '\'' +
                        ",story_text = '" + storyText + '\'' +
                        ",author = '" + author + '\'' +
                        ",story_id = '" + storyId + '\'' +
                        ",_tags = '" + tags + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",created_at_i = '" + createdAtI + '\'' +
                        ",title = '" + title + '\'' +
                        ",url = '" + url + '\'' +
                        ",points = '" + points + '\'' +
                        ",_highlightResult = '" + highlightResult + '\'' +
                        ",num_comments = '" + numComments + '\'' +
                        ",story_title = '" + storyTitle + '\'' +
                        ",parent_id = '" + parentId + '\'' +
                        ",story_url = '" + storyUrl + '\'' +
                        ",relevancy_score = '" + relevancyScore + '\'' +
                        ",objectID = '" + objectID + '\'' +
                        "}";
    }
}