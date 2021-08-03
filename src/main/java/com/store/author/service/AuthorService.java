package com.store.author.service;

import com.store.author.model.Author;
import com.store.author.repository.AuthorInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorInterface authorRepository;


    public String getAuthorName(String id) {
        return authorRepository.findNameById(Long.valueOf(id));
    }

    public List<Author> getAllAuthors() {
        log.info("getting all authors...");
        return (List<Author>) authorRepository.findAll();
    }

    public Long getAuthorID(String authorName) {
        Author author= authorRepository.findByFirstName(authorName);
        return author.getId();
    }
}
