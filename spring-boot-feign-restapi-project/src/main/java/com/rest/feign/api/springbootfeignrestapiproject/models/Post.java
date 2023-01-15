package com.rest.feign.api.springbootfeignrestapiproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;
}
