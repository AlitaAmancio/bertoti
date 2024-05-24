package com.bookAdoption.adoptabook.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookAdoption.adoptabook.entity.Author;
import com.bookAdoption.adoptabook.entity.Book;
import com.bookAdoption.adoptabook.entity.Category;
import com.bookAdoption.adoptabook.repository.AuthorInterface;
import com.bookAdoption.adoptabook.repository.BookInterface;
import com.bookAdoption.adoptabook.repository.CategoryInterface;

@Service
public class BookService {

    @Autowired
    private BookInterface bookInterface;
    @Autowired
    private AuthorInterface authorInterface;
    @Autowired
    private CategoryInterface categoryInterface;

    public List<Book> getAllBooks() {
        return bookInterface.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookInterface.findById(id);
    }

    public List<Book> getBooksByTitle(String title) {
        Optional<List<Book>> books = bookInterface.findByTitleContainingIgnoreCase(title);
        if (books.isPresent()) {
            return books.get();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Book> getBooksByAuthorName(String authorName) {
        Optional<Author> author = authorInterface.findByNameIgnoreCase(authorName);
        if (author.isPresent()) {
            return author.get().getBooks();
        } else {
            return Collections.emptyList();
        }
    }

    public List<Book> getBooksByCategoryName(String categoryName) {
        Optional<Category> category = categoryInterface.findByNameIgnoreCase(categoryName);
        if (category.isPresent()) {
            return category.get().getBooks();
        } else {
            return Collections.emptyList();
        }
    }

    public Book addBook(Book book) {
        return bookInterface.save(book);
    }

    public Book updateBookById(Long id, Book newBookData) {
        Optional<Book> bookData = bookInterface.findById(id);
        if (bookData.isPresent()) {
            Book updatedBookData = bookData.get();
            updatedBookData.setTitle(newBookData.getTitle());
            updatedBookData.setDescription(newBookData.getDescription());
            updatedBookData.setCoverType(newBookData.getCoverType());
            updatedBookData.setPublicationDate(newBookData.getPublicationDate());
            if (newBookData.getAuthor() != null) {
                updatedBookData.setAuthor(newBookData.getAuthor());
            }
            if (newBookData.getCategories() != null) {
                updatedBookData.setCategories(newBookData.getCategories());
            }
            return bookInterface.save(updatedBookData);
        } else {
            return null;
        }
    }

    public void deleteBookById(Long id) {
        bookInterface.deleteById(id);
    }

}
