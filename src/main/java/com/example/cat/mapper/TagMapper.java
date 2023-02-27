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

    @Named("tagDtoToTag")
    default Tag tagDtoToTag(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setTagName(tagDto.getTagName());
        tag.setTagClass(Tag.TagClass.valueOf(tagDto.getTagName()));
        return tag;
    }

    @Named("tagToTagDto")
    default TagDto tagToTagDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setTagName(tag.getTagName());
        tagDto.setTagClass(tag.getTagClass().name());
        return tagDto;
    }

    @IterableMapping(qualifiedByName = "tagToTagDto")
    List<TagDto> tagsToTagsDto(List<Tag> role);

    @IterableMapping(qualifiedByName = "tagDtoToTag")
    List<Tag> tagsDtoToTags(List<TagDto> role);

}
