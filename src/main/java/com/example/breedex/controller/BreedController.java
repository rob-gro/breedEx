package com.example.breedex.controller;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import com.example.breedex.service.BreedService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BreedController {

    private final BreedService breedService;

    public BreedController(BreedService breedService) {
        this.breedService = breedService;
    }

    @RequestMapping("/breeds")
    public String getAllBreeds(Model model) {
        model.addAttribute("breedList", breedService.findAllBreeds());
        return "breeds";
    }

    @GetMapping("/breeds/new")
    public String newBreed(Model model) {
        model.addAttribute("breed", new Breed());
        return "breed_new_form";
    }

    @GetMapping("/breeds/{id}/edit")
    public String showEditBreedForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("breed", breedService.findBreedById(id));
        model.addAttribute("variety", new Variety());
        return "breed_edit_form";
    }

    @PostMapping("/breeds/save")
    public String saveBreed(@ModelAttribute Breed breed, Model model) {
        model.addAttribute("breed",
                breedService.createBreed(breed.getBreedName(), breed.getVarieties()));
        return "redirect:/breeds";
    }

    @GetMapping("breeds/{id}/delete")
    public String deleteBreed(@PathVariable("id") Long id) {
        breedService.deleteBreedById(id);
        return "redirect:/breeds";
    }

    @RequestMapping(value = "/breeds/{id}/varieties/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteVariety(@PathVariable("id") Long id, @RequestParam("index") int index) {
        breedService.deleteVariety(id, index);
        return "redirect:/breeds/{id}/edit";
    }

    @PostMapping("/breeds/{id}/varieties/add")
    public String addVariety(@PathVariable("id") Long id, Variety variety) {
        breedService.addVariety(id, variety.getVarietyName());
        return "redirect:/breeds";
    }
}