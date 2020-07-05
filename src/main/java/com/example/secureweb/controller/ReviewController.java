package com.example.secureweb.controller;

import com.example.secureweb.service.ReviewService;
import com.example.secureweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService service;

    @Autowired
    private UserService userService;

}
