package com.sport.blog.dao;

import com.sport.blog.model.Post;

public interface PostDAO {
	public Post getPostByText(Post name);
    public Post getPostByTitle(Post title);
}
