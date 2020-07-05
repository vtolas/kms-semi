package com.example.secureweb.controller;

import com.example.secureweb.entity.FahrAngebot;
import com.example.secureweb.entity.Review;
import com.example.secureweb.entity.User;
import com.example.secureweb.service.ReviewService;
import com.example.secureweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private ReviewService service;

    @Autowired
    private UserService userService;

    @GetMapping("/reviews")
    public void goToReviews(@RequestParam(value = "id", required = true) Integer id, Model model){
        User u = new User();
        u = userService.findById(id);
        model.addAttribute("user", id);
        model.addAttribute("userFullName", u.getName() +" "+ u.getLastName());
        List<Review> l = service.getReviewsByReviewedUser(id);
        for (Review r: l) {
            User reviewer = new User();
            reviewer = userService.findById(r.getAuthor());
            r.setAuthorFullName(reviewer.getName() + " "+ reviewer.getLastName() );
        }

        model.addAttribute("reviews", service.getReviewsByReviewedUser(id));
    }

    @GetMapping("/add-review")
    public void findAllReviewsByUserId(@RequestParam(value = "id", required = true) Integer id, Model model){
        model.addAttribute("reviewedUser", id);
        User u = new User();
        u = userService.findById(id);
        model.addAttribute("userFullName", u.getName() +" "+ u.getLastName());
    }

    @PostMapping("/add-review")
    public RedirectView addReview(@RequestParam(value = "id", required = true) Integer id, Review r, RedirectAttributes redir){
        User user = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            user = userService.findByEmail(currentUserName);
            r.setAuthor(user.getId());

        }
        r.setReviewedUser(id);

        service.saveReview(r);

        RedirectView  redirectView= new RedirectView("/reviews?id="+id,true);
        redir.addFlashAttribute("message",
                "You successfully added a new Review");
        return redirectView;
    }
}
