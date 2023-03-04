package com.example.cat.mapper;


import com.example.cat.dto.TagDto;
import com.example.cat.model.Tag;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TagMapper {

    default TagDto tagToTagDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setTagName(tag.getTagName());
        tagDto.setTagClass(tag.getTagClass().name());
        return tagDto;
    }

//    List<TagDto> tagsToTagsDto(List<Tag> role);
}
