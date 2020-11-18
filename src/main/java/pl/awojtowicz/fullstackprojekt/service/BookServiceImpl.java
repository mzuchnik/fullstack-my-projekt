package pl.awojtowicz.fullstackprojekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.awojtowicz.fullstackprojekt.entity.Book;
import pl.awojtowicz.fullstackprojekt.repo.BookRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepo.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepo.deleteById(id);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabase(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("In Search of Lost Time","Marcel Proust",10,0));
        books.add(new Book("Ulysses","James Joyce",10,0));
        books.add(new Book("Don Quixote","Miguel de Cervantes",8,0));
        books.add(new Book("One Hundred Years of Solitude","Gabriel Garcia Marquez",10,0));
        books.add(new Book("Moby Dick","Herman Melville",9,0));
        books.add(new Book("War and Peace","Leo Tolstoy",10,0));
        books.add(new Book("Lolita","Vladimir Nabokov",10,0));
        books.add(new Book("Hamlet","William Shakespeare",7,0));
        books.add(new Book("The Catcher in the Rye","J. D. Salinger",10,0));
        books.add(new Book("The Odyssey","Homer",9,0));
        bookRepo.saveAll(books);
    }
}
