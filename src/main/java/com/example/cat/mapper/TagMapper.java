package com.example.cat.mapper;


import com.example.cat.dto.TagDto;
import com.example.cat.model.Tag;
import com.example.cat.model.TagClass;
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
        tag.setTagClass(TagClass.valueOf(tagDto.getTagName()));
        return tag;
    }

    @Named("tagToTagDto")
    default TagDto tagToTagDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setTagClass(tag.getTagName());
        return tagDto;
    }

    @IterableMapping(qualifiedByName = "tagToTagDto")
    List<TagDto> tagsToTagsDto(List<Tag> role);

    @IterableMapping(qualifiedByName = "tagDtoToTag")
    List<Tag> tagsDtoToTags(List<TagDto> role);

}
