package com.bookAdoption.adoptabook.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookAdoption.adoptabook.entity.Author;
import com.bookAdoption.adoptabook.repository.AuthorInterface;

@Service
public class AuthorService {

    @Autowired
    private AuthorInterface authorInterface;

    public List<Author> getAllAuthors() {
        return authorInterface.findAll();
    }

    public Optional<Author> getAuthorById(Long id) {
        return authorInterface.findById(id);
    }

    public List<Author> getAuthorsByName(String name) {
        Optional<List<Author>> authors = authorInterface.findByNameContainingIgnoreCase(name);
        if (authors.isPresent()) {
            return authors.get();
        } else {
            return Collections.emptyList();
        }
    }

    public Author saveAuthor(Author author) {
        return authorInterface.save(author);
    }

    public Author updateAuthorById(Long id, Author newAuthorData) {
        Optional<Author> authorData = authorInterface.findById(id);
        if (authorData.isPresent()) {
            Author updatedAuthorData = authorData.get();
            updatedAuthorData.setName(newAuthorData.getName());
            updatedAuthorData.setBiography(newAuthorData.getBiography());
            updatedAuthorData.setBirthdate(newAuthorData.getBirthdate());
            if (newAuthorData.getBooks() != null) {
                updatedAuthorData.setBooks(newAuthorData.getBooks());
            }
            return authorInterface.save(updatedAuthorData);
        } else {
            return null;
        }
    }

    public void deleteAuthorById(Long id) {
        authorInterface.deleteById(id);
    }
    
}
