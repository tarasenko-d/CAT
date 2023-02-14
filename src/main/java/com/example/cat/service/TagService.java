package com.example.cat.service;

import com.example.cat.dao.TagDao;
import com.example.cat.exception.NoSuchEntryException;
import com.example.cat.model.Tag;
import com.example.cat.model.TagClass;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private final TagDao tagDao;
    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }


    public void saveTag(Tag tag) {
        tagDao.save(tag);
    }

    public void deleteTag(Tag tag) {
        tagDao.delete(tag);
    }

    @Transactional
    public void editTag(Tag tagEdit) {
        Optional<Tag> tagOptional = tagDao.findById(tagEdit.getId());
        if (tagOptional.isEmpty()) {
            throw new NoSuchEntryException();
        }

        Tag tag = tagOptional.get();
        if (tagEdit.getTagName() != null) tag.setTagName(tagEdit.getTagName());
        if (tagEdit.getTagClass() != null) tag.setTagClass(tagEdit.getTagClass());
      //  if (tagEdit.getEvents() != null) tag.setEvents(tagEdit.getEvents());
        tagDao.save(tag);
    }

    public List<Tag> getAllTags() {
        return (List<Tag>) tagDao.findAll();
    }

    @Transactional
    public List<Tag> getAllTagsWithEvents() {
        List<Tag> tags = (List<Tag>) tagDao.findAll();
      /*  for (Tag tag : tags){
            Hibernate.initialize(tag.getEvents());
        }*/
        return tags;
    }

    public List<Tag> getAllTagsByClass(TagClass tagClassEnum) {
        return tagDao.getTagsByTagClass(tagClassEnum);
    }
}
