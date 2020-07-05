package com.example.secureweb.controller;


import com.example.secureweb.entity.FahrAngebot;
import com.example.secureweb.service.FahrAngebotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class FahrAngebotController {

    @Autowired
    private FahrAngebotService service;

    @PostMapping("/addFahrangebot")
    public RedirectView addFA(FahrAngebot fa, RedirectAttributes redir){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println("User is: "+currentUserName);
            fa.setUser(currentUserName);
        }

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            System.out.println("User is: "+currentUserName);
        }

        List<FahrAngebot> list = service.getFahrAngebote();

        model.addAttribute("fahrangebote", list);

        return "my-offers";
    }

    @GetMapping("/fahrangebot/{id}")
    public FahrAngebot findAllFahrangebotById(@PathVariable int id){
        return service.getFahrAngebotById(id);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable int id){
        return service.deleteFahrAngebot(id);
    }

    @GetMapping("/result")
    public List<FahrAngebot> showresults(FahrAngebot angebot, RedirectAttributes redir){
        List<FahrAngebot> list = service.findresult(angebot.getDatum(),angebot.getStartOrt(),angebot.getZielOrt());
        System.out.println(list);
        RedirectView rediview = new RedirectView("/result",true);
        redir.addAttribute("results",list);
        return list;
    }

}
