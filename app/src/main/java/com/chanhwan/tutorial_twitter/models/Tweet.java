package com.chanhwan.tutorial_twitter.models;

/**
 * Created by Chanhwan on 2015-10-06.
 */
public class Tweet {
    private String id;
    private String title;
    private String body;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
