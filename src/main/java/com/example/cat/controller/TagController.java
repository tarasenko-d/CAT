package com.example.cat.controller;

import com.example.cat.mapper.TagMapper;
import com.example.cat.service.TagService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    private TagService tagService;
    private TagMapper tagMapper;

    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }



}