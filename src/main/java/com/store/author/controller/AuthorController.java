package com.store.author.controller;

import com.store.author.model.Author;
import com.store.author.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AuthorController {

    private final static Logger logger= LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/fetch/book/{id}")
   public String getAuthorName(@PathVariable String id){
        return  authorService.getAuthorName(id);
    }

    @GetMapping(value = "/getAuthors")
    public List<Author> getAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping(value = "/{authorName}")
    public Long returnAuthorID(@PathVariable String authorName){
        logger.info("Querying author repo... for author id");
        return authorService.getAuthorID(authorName);

    }

}
