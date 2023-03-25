package com.sprinfboot.blog.service;

import com.sprinfboot.blog.entity.Comment;
import com.sprinfboot.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(long postId,Long commentId);

    CommentDto updateComment(long postId, long commentId, CommentDto commentReq);

    void deleteComment(long postId,Long commentId);
}
