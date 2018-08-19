package com.example.spring5webapp.controller;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private static final String MODEL = "authors";

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        Iterable<Author> authors = authorRepository.findAll();
        model.addAttribute(MODEL, authors);
        return MODEL;
    }
}
