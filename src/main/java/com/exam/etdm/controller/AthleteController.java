package com.exam.etdm.controller;

import com.exam.etdm.model.Athlete;
import com.exam.etdm.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AthleteController
{

        @Autowired
    private AthleteService athleteService;


    @GetMapping(value = {"/etdm/athlete/list"})
    public ModelAndView listAthletes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("athletes", athleteService.getAllAthletesPaged());
        modelAndView.setViewName("list");
        return modelAndView;
    }




    @GetMapping(value = {"/etdm/athlete/new"})
    public String displayNewAthleteForm(Model model) {
        model.addAttribute("athlete", new Athlete());
        return "new";
    }

    @PostMapping(value = {"/etdm/athlete/new"})
    public String addNewAthlete(@Valid @ModelAttribute("athlete") Athlete athlete,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "new";
        }
        athlete = athleteService.saveAthlete(athlete);
        return "redirect:/etdm/athlete/list";
    }


    @GetMapping(value = {"/etdm/athlete/elitelist"})
    public ModelAndView eliteAthletes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("athletes", athleteService.getEliteAthletesList());
        modelAndView.setViewName("list");
        return modelAndView;
    }






}
