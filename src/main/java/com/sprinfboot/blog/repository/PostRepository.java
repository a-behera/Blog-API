package com.sprinfboot.blog.repository;

import com.sprinfboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
