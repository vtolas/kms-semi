package com.example.secureweb.controller;


import com.example.secureweb.entity.FahrAngebot;
import com.example.secureweb.entity.Review;
import com.example.secureweb.entity.User;
import com.example.secureweb.service.FahrAngebotService;
import com.example.secureweb.service.UserService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Controller
public class FahrAngebotController {

    @Autowired
    private FahrAngebotService service;

    @Autowired
    private UserService userService;


    @PostMapping("/addFahrangebot")
    public RedirectView addFA(FahrAngebot fa, RedirectAttributes redir){
        User user = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            user = userService.findByEmail(currentUserName);
        }
        fa.setUserId(user.getId());
        fa.setUser(user.getEmail());
        service.saveFahrAngebot(fa);

        RedirectView  redirectView= new RedirectView("/my-offers",true);
        redir.addFlashAttribute("message",
                "You successfully added a new ride");
        return redirectView;
    }

    @PostMapping("/addFahrangebote")
    public List<FahrAngebot> addFA(@RequestBody List<FahrAngebot> fa){
        return service.saveFahrAngebote(fa);
    }

    @GetMapping("/my-offers")
    public String findAllFahrangebote(Model model){
        User user = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            user = userService.findByEmail(currentUserName);
        }

        List<FahrAngebot> list = service.getFahrAngebote();
        List<FahrAngebot> result = new ArrayList<FahrAngebot>();

        String email = user.getEmail();

        for (FahrAngebot fa: list) {
            if(email != null) {
                if (fa.getUser().contains(email)) {
                    result.add(fa);
                }
            }
        }


        //CollectionUtils.filter(list, fa -> ((FahrAngebot) fa).getUser() == email);
        model.addAttribute("fahrangebote", result);
        model.addAttribute("user", user);

        return "my-offers";
    }

    @GetMapping("/fahrangebot/{id}")
    public FahrAngebot findAllFahrangebotById(@PathVariable int id){
        return service.getFahrAngebotById(id);
    }

    @GetMapping("/result")
    public List<FahrAngebot> showresults(FahrAngebot angebot, Model model){

        List<FahrAngebot> list = service.findResults(angebot.getStartOrt(), angebot.getZielOrt(), angebot.getDatum());
        for (FahrAngebot r: list) {
            User u = new User();
            u = userService.findByEmail(r.getUser());
            r.setUserFullName(u.getName() + " "+ u.getLastName() );
            r.setUserId(u.getId());
        }

        model.addAttribute("results", list);
        return list;
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable int id){
        return service.deleteFahrAngebot(id);
    }
}
