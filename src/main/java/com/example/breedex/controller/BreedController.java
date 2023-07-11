package com.example.breedex.controller;

import com.example.breedex.model.Breed;
import com.example.breedex.model.Variety;
import com.example.breedex.service.BreedService;
import com.example.breedex.service.VarietyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BreedController {

    private final BreedService breedService;
    private final VarietyService varietyService;

    public BreedController(BreedService breedService, VarietyService varietyService) {
        this.breedService = breedService;
        this.varietyService = varietyService;
    }

    @RequestMapping("/breeds")
    public String getAllBreeds(Model model) {
        model.addAttribute("breedList", breedService.getAllBreeds());
        return "breeds";
    }

    @GetMapping("/breeds/new")
    public String newBreed(Model model) {
        model.addAttribute("breed", new Breed());
        return "breed_new_form";
    }

//    @GetMapping("/breeds/{id}/edit")
//    public String editBreed(@PathVariable("id") Long id, @ModelAttribute Variety variety, @ModelAttribute Breed breedId, Model model) {
////        model.addAttribute("breed", breedService.getBreedById(id));
////        System.out.println(" ***** powinno pobrać breed z id: " + breedService.getBreedById(id));
////        model.addAttribute("variety", varietyService.getVarietiesByBreedId(id));
////        System.out.println(" ***** powinno pobrać variety do podanego breed " + varietyService.getVarietiesByBreedId(id));
//
//
//
//        Breed breed = breedService.getBreedById(id);
//        System.out.println(" **********  jestem za funkcją getBreedById  w breed konstruktorze*****************");
//        System.out.println(" ************* Nazwa 'breed': " + breedId.getVarieties().stream().map(v -> v.getVarietyName().toString()) + "  w breed konstruktorze ********************");
//        List<Variety> varieties = varietyService.getVarietiesByBreedId(id);
//        System.out.println(" ********** czy mam jakieś 'variety': " + varieties.get(id.intValue())+ "  w breed konstruktorze ***********");
//
//
//
//        model.addAttribute("breed", breed);
//        model.addAttribute("varieties", varieties);
//        return "breed_edit_form";
//    }

//    @GetMapping("/breeds/{id}/edit")
//    public String editBreed(@PathVariable("id") Long id, @ModelAttribute Variety variety, Model model) {
//        Breed breed = breedService.getBreedById(id);
//        System.out.println(" **********  jestem za funkcją getBreedById  w variety konstruktorze*****************");
//                System.out.println(" ************* Nazwa 'breed': " + breed.getBreedName() + "  w variety konstruktorze ********************");
//        List<Variety> varieties = varietyService.getVarietiesByBreedId(id);
//        System.out.println(" ********** czy mam jakieś 'variety': " + variety.getVarietyName()+ "  w variety konstruktorze ***********");
//
//        model.addAttribute("breed", breed);
//        model.addAttribute("varieties", varieties);
//        return "breed_edit_form";
//    }

    @GetMapping("/breeds/{id}/edit")
    public String editBreed(@PathVariable("id") Long id, @ModelAttribute Variety variety, Model model) {
         Breed breed = breedService.getBreedById(id);
        System.out.println(" ****** udało sie podać breed do kontrolera  ************");
//        model.addAttribute("breed", breed);

        System.out.println(" **********  jestem za funkcją getBreedById *****************");
//        System.out.println(" ************* Nazwa breed/rasy: " + breed.getBreedName() + "  ********************");


        model.addAttribute("variety", varietyService.getVarietiesByBreedId(breed.getId()));           // dobre
        System.out.println(" ********** niby mam jakieś variety: " + variety.getVarietyName() + "  ***********");

//        model.addAttribute("breed", breed);
        model.addAttribute("breed", breed);
                System.out.println(" ************* Nazwa breed/rasy: " + breed.getBreedName() + "  ********************");
//        model.addAttribute("varieties", variety);
        return "breed_edit_form";
    }
    //        model.addAttribute("variety", varietyService.getVarietyById(breed.getId()));


//    @GetMapping("/breeds/{id}/edit")
//        public String updateBreed(@PathVariable("id") Long id, @ModelAttribute Breed breed) {
//            breed.setId(id);
//            breedService.updateBreed(breed);
//            return "redirect:/breeds";
//    }



    @PostMapping("/breeds/save")
    public String saveBreed(@ModelAttribute Breed breed) {
        breedService.saveBreed(breed);
        return "redirect:/breeds";
    }

//    @PostMapping("/breeds/save")
//    public String saveBreed(@ModelAttribute Breed breed, @ModelAttribute Variety variety) {
//        Breed existingBreed = breedService.getBreedById(breed.getId());
//        existingBreed.setVarieties(variety.getBreed().getVarieties());
//        breedService.saveBreed(existingBreed);
//        return "redirect:/breeds";
//    }


//    @PostMapping("/breeds/save")
//    public String saveBreed(@ModelAttribute Breed breed, @ModelAttribute Variety variety) {
//        varietyService.saveVariety(variety);
//        breed.setId(breed.getId());
//        breedService.addVarietyToBreed(breed.getId(), variety);
//        breedService.saveBreed(breed);
//        return "redirect:/breeds";
//    }

    @GetMapping("breeds/{id}/delete")
    public String deleteBreed(@PathVariable("id") Long id) {
        breedService.deleteBreedById(id);
        return "redirect:/breeds";
    }
}


