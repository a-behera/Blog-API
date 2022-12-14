package com.springboot.blog.payload;

import com.springboot.blog.entity.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
    private long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Email should not empty")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 10,message = "Comment should be minimum 10 character")
    private String body;
}
