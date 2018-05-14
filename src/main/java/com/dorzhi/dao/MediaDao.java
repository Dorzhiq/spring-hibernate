package com.dorzhi.dao;

import com.dorzhi.content.Content;

import java.util.List;

public interface MediaDao {
    public void save(Content content);
    public List<Content> getAll();
}
