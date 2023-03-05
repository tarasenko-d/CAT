package com.example.cat.service;

import com.example.cat.dao.TagDao;
import com.example.cat.exception.NoSuchEntryException;
import com.example.cat.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagDao tagDao;

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

        if (tagEdit.getTagName() != null) {
            tag.setTagName(tagEdit.getTagName());
        }
        if (tagEdit.getTagClass() != null) {
            tag.setTagClass(tagEdit.getTagClass());
        }

        tagDao.save(tag);
    }

    public List<Tag> getAllTags() {
        List<Tag> tags = (List<Tag>) tagDao.findAll();

        if (tags.isEmpty()) {
            throw new NoSuchEntryException("Теги не найдены");
        }

        return tags;
    }

    public List<Tag> getByNames(List<String> names) {
        List<Tag> tags = tagDao.findAllByTagNameIn(names);

        if (tags.isEmpty()) {
            throw new NoSuchEntryException("Теги не найдены");
        }

        return tags;
    }

    public List<Tag> getAllTagsByClass(String className) {
        Tag.TagClass tagClass = Tag.TagClass.from(className);
        List<Tag> tags = tagDao.getTagsByTagClass(tagClass);

        if (tags.isEmpty()) {
            throw new NoSuchEntryException("Теги не найдены");
        }

        return tags;
    }
}
