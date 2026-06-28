package com.skillsharehub.Model;

import java.util.ArrayList;

public class ProjectModel {

    private String title;
    private String author;
    private String description;
    private String category;
    private ArrayList<String> technologies;
    private int likes;

    public ProjectModel(String title,
                        String author,
                        String description,
                        String category,
                        ArrayList<String> technologies,
                        int likes) {

        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.technologies = technologies;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<String> getTechnologies() {
        return technologies;
    }

    public int getLikes() {
        return likes;
    }
}