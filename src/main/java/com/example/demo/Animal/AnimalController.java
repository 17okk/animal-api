package com.example.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// @RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animals-details";
    }

    @GetMapping("")
    public String getAnimalsBySpecies(@RequestParam(name="species", defaultValue="panda") String species, Model model) {
        model.addAttribute("animalList", service.getAnimalsBySpecies(species));
        model.addAttribute("title", "Animals Species: " + species);
        return "animal-list";
    }

    @GetMapping("/name")
    public String getAnimalsScientific(@RequestParam(name="scientificName", defaultValue="panda") String scientificName, Model model) {
        model.addAttribute("animalList", service.getAnimalsScientific(scientificName));
        model.addAttribute("title", "Animals Scientific: " + scientificName);
        return "animal-list";
    }

    @PostMapping("/new")
    public String addNewAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalsById(animalId));
        return "student-update";
    }

    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    @GetMapping("/delete/{animalId}")
    public String deleteAnimalsById(@PathVariable int animalId) {
        service.deleteAnimalsById(animalId);
        return "redirect:/animals/all";
    }
}
