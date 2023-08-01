package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void saveBook(BookCreateRequest request) {
//        bookMemoryRepository.saveBook();
//        bookMySqlRepository.saveBook();

        bookRepository.save(new Book(request.getName()));
    }
}
