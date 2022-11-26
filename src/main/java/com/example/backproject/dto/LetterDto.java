package com.example.backproject.dto;

public class LetterDto {
    private String letterId;
    private String writer;
    private String email;
    private String comment;
    private String createTime;

    public LetterDto() {
    }

    public LetterDto(String writer, String email, String comment) {
        this.writer = writer;
        this.email = email;
        this.comment = comment;
    }

    public LetterDto(String letterId, String writer, String comment, String createTime) {
        this.letterId = letterId;
        this.writer = writer;
        this.comment = comment;
        this.createTime = createTime;
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

    public String getLetterId() {
        return letterId;
    }

    public void setLetterId(String letterId) {
        this.letterId = letterId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LetterDto{" +
                "letterId='" + letterId + '\'' +
                ", writer='" + writer + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}