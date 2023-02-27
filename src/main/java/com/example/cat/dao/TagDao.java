package com.example.cat.dao;

import com.example.cat.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TagDao extends CrudRepository<Tag, Long> {

    @Override
    Optional<Tag> findById(Long aLong);

    List<Tag> getTagsByTagClass(Tag.TagClass tagClassEnum);

}
