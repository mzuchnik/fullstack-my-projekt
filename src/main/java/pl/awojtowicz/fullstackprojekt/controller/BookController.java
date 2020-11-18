package pl.awojtowicz.fullstackprojekt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.awojtowicz.fullstackprojekt.entity.Book;
import pl.awojtowicz.fullstackprojekt.service.BookService;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        List<Book> bookList = bookService.findAll();

        model.addAttribute("bookList", bookList);
        model.addAttribute("newBook", new Book());

        return "index";
    }

    @PostMapping
    public String addNewBook(@ModelAttribute("newBook") Book newBook) {
        bookService.save(newBook);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditBookPage(@PathVariable(name = "id") long id, Model model) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find book for id: " + id));

        model.addAttribute("editBook", book);
        return "edit-book";
    }

    @PostMapping("/processEdit")
    public String processUpdateBook(@ModelAttribute("editBook") Book editBook){
        bookService.save(editBook);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteBookById(@PathVariable(name = "id") long id)
    {
        bookService.deleteById(id);
        return "redirect:/";
    }

}
