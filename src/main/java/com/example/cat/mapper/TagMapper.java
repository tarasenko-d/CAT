package com.example.cat.mapper;

import com.example.cat.dto.TagDto;
import com.example.cat.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagDto tagToTagDto(Tag tag);
}
