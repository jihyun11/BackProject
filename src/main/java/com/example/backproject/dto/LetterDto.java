package com.example.backproject.dto;

public class LetterDto {
    private String writer;
    private String email;
    private String comment;

    public LetterDto(String writer, String email, String comment) {
        this.writer = writer;
        this.email = email;
        this.comment = comment;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "LetterDto{" +
                "writer='" + writer + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
