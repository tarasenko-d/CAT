package com.example.cat.dao;

import com.example.cat.model.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagDao extends CrudRepository<Tag, Long> {

    Optional<Tag> findById(Long aLong);

    List<Tag> getTagsByTagClass(Tag.TagClass tagClassEnum);

    List<Tag> findAllByTagNameIn(List<String> names);
}
