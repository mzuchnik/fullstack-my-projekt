package pl.awojtowicz.fullstackprojekt.service;

import pl.awojtowicz.fullstackprojekt.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(long id);

    void save(Book book);

    void delete(Book book);

    void deleteById(long id);

}
