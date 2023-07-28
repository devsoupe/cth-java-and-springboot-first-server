package com.group.libraryapp.service.book;

import com.group.libraryapp.repository.book.BookMemoryRepository;
import com.group.libraryapp.repository.book.BookMySqlRepository;
import com.group.libraryapp.repository.book.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

//    private final BookMemoryRepository bookMemoryRepository = new BookMemoryRepository();
//    private final BookMySqlRepository bookMySqlRepository = new BookMySqlRepository();

//    private final BookRepository bookRepository = new BookMemoryRepository();
//    private final BookRepository bookRepository = new BookMySqlRepository();

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
//        bookMemoryRepository.saveBook();
//        bookMySqlRepository.saveBook();

        bookRepository.saveBook();
    }
}
