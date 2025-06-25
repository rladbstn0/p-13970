package com.back.domain.post.post.dto;

import com.back.domain.post.post.entity.Post;

import java.time.LocalDateTime;

public record PostDto(
        int id,
        LocalDateTime createDate,
        LocalDateTime modifiyDate,
        String subject,
        String body
) {
    public PostDto(Post post) {
        this(
                post.getId(),
                post.getCreateDate(),
                post.getModifyDate(),
                post.getTitle(),
                post.getContent()
        );
    }
}