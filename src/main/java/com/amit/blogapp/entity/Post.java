package com.amit.blogapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Post {
    @Id
    private Long id;
    private String content;
}
