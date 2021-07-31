package com.store.author.repository;

import com.store.author.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorInterface  extends CrudRepository<Author,Long> {

    @Query(value = "SELECT NAME FROM AUTHOR where id=:id",nativeQuery = true)
    String findNameById(Long id);


    Author findByFirstName(String authorName);
}
