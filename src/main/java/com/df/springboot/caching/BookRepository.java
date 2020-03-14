package com.df.springboot.caching;

import org.springframework.stereotype.Repository;

import com.df.springboot.Book;

@Repository
public interface BookRepository {
	public Book getBookByIsbn(String isbn);
}
