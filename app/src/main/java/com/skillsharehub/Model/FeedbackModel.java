package com.skillsharehub.Model;

public class FeedbackModel {

    private String name;
    private String course;
    private String feedback;
    private String date;

    public FeedbackModel(String name, String course, String feedback, String date) {
        this.name = name;
        this.course = course;
        this.feedback = feedback;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getDate() {
        return date;
    }
}