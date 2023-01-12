package com.denver7074.bookManager.controllers;

import com.denver7074.bookManager.DAO.ImageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class ImageController {
    private final ImageDAO imageDAO;
    //Сомнение что так...
    @GetMapping("/{id}")
    public String getImage(@PathVariable("id") Long id){
        imageDAO.getImageById(id);
        return "redirect:/books";
    }
}
