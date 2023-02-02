package com.example.demo.service;

import com.example.demo.dao.TagDao;
import com.example.demo.exception.NoSuchEntryException;
import com.example.demo.model.Tag;
import com.example.demo.model.TagClass;
import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }


    @Override
    public void saveTag(Tag tag) {
        tagDao.save(tag);
    }

    @Override
    public void deleteTag(Tag tag) {
        tagDao.delete(tag);
    }

    @Transactional
    @Override
    public void editTag(Tag tagEdit) {
        Optional<Tag> tagOptional = tagDao.findById(tagEdit.getId());
        if (tagOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }

        Tag tag = tagOptional.get();
        if (tagEdit.getTagName() != null) tag.setTagName(tagEdit.getTagName());
        if (tagEdit.getTagClass() != null) tag.setTagClass(tagEdit.getTagClass());
        if (tagEdit.getEvents() != null) tag.setEvents(tagEdit.getEvents());
        tagDao.save(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return (List<Tag>) tagDao.findAll();
    }

    @Transactional
    @Override
    public List<Tag> getAllTagsWithEvents() {
        List<Tag> tags = (List<Tag>) tagDao.findAll();
        for (Tag tag : tags){
            Hibernate.initialize(tag.getEvents());
        }
        return tags;
    }

    @Override
    public List<Tag> getAllTagsByClass(TagClass tagClass) {
        return tagDao.getTagsByTagClass(tagClass);
    }
}
