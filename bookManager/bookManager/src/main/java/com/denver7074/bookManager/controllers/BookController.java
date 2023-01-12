package com.denver7074.bookManager.controllers;

import com.denver7074.bookManager.DAO.BookDAO;
import com.denver7074.bookManager.model.Books;
import com.denver7074.bookManager.model.constant.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookDAO bookDAO;

    @GetMapping
    public String showBooks(@PathVariable(name = "title") String title, Model model){
        model.addAttribute("books",bookDAO.booksList(title));
        return "/books";
    }

    @PostMapping("/addBook")
    public String addBook(Books book,
                          MultipartFile file){
    bookDAO.addBook(book,file);
    return "redirect:/books";
    }
    @PostMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id){
        bookDAO.deleteBook(id);
        return "redirect:/books";
    }
    @PostMapping("/updateBook/{id}")
    public String updateBook(String titleBook,
                             String author,
                             double price,
                             LocalDate yearWrite,
                             Genre genre,
                             String isbn,
                             Long id){
        bookDAO.updateBook(titleBook,author,price,yearWrite,genre,isbn,id);
        return "redirect:/books";
    }
    @GetMapping("/bookInfo/{id}")
    public String bookInfo(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("book",bookDAO.bookInfo(id));
        return "/bookInfo";
    }



}
