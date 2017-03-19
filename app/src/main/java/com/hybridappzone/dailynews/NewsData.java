package com.hybridappzone.dailynews;

/**
 * Created by Vasanth on 17-03-2017.
 */

public class NewsData {

    private String author, urlToImage, getUrl;
    private String publishedAt;
    private String title;
    private String description;

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getUrl() {
        return getUrl;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
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


}
