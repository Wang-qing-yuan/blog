package com.myvlog.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Book {
    private Long id;
    private String title;
    private String content;
    private String cover;
    private Integer diamond;
    private String nickname;
    private Integer comments;
    private Integer likes;
    private LocalDateTime publishTime;

}
