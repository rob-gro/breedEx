package com.example.breedex.controller;

import com.example.breedex.model.Breed;
import com.example.breedex.service.BreedService;
import com.example.breedex.service.VarietyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BreedController {

    private final BreedService breedService;
    private final VarietyService varietyService;

    public BreedController(BreedService breedService, VarietyService varietyService) {
        this.breedService = breedService;
        this.varietyService = varietyService;
    }

    @RequestMapping("/")
    public String getAllBreeds(Model model) {
        model.addAttribute("breedList", breedService.getAllBreeds());
        return "breeds";
    }

    @GetMapping("/breeds/new")
    public String newBreed(Model model) {
        model.addAttribute("breed", new Breed());
        return "breed_new_form";
    }

    @GetMapping("/breed/{id}/edit")
    public String editBreed(@PathVariable("id") Long id, Model model) {
        model.addAttribute("breed", breedService.getBreedById(id));
        return "breed_edit_form";
    }


    @PostMapping("/breeds/save")
    public String saveBreed(@ModelAttribute Breed breed) {
        breedService.saveBreed(breed);
        return "breeds";
    }

    @GetMapping("breed/{id}/delete")
    public String deleteBreed(@PathVariable("id") Long id) {
        breedService.deleteBreedById(id);
        return "redirect:/breeds";
    }
}


