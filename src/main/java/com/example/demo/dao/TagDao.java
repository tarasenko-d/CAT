package com.example.demo.dao;

import com.example.demo.model.Tag;
import com.example.demo.model.TagClass;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TagDao extends CrudRepository<Tag, Long> {

    @Override
    Optional<Tag> findById(Long aLong);

    List<Tag> getTagsByTagClass(TagClass tagClass);

}
