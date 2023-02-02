package com.example.demo.service;

import com.example.demo.model.Tag;
import com.example.demo.model.TagClass;

import java.util.List;

public interface TagService {

    void saveTag(Tag tag);
    void deleteTag(Tag tag);
    void editTag(Tag tag);

    List<Tag> getAllTags();
    List<Tag> getAllTagsWithEvents();
    List<Tag> getAllTagsByClass(TagClass tagClass);

}
