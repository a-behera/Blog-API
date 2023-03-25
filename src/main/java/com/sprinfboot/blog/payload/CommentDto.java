package com.sprinfboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private long id;
    @NotEmpty(message = "Name Should not be null or empty")
    private String name;
    @NotEmpty(message = "Email is required")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 10,message = "min 10 character required")
    private String body;
}
