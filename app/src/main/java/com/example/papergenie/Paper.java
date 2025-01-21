package com.example.papergenie;

public class Paper {
    private int id;
    private String title,time,marks,questions,link;

    public Paper() {
    }

    public Paper(int id,String title, String time,String marks, String questions,String link) {
        this.id = id;
        this.marks = marks;
        this.time =time;
        this.title = title;
        this.questions = questions;
        this.link =link;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
