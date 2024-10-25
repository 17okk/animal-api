package com.example.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.getAnimalsBySpecies(species);
    }

    public List<Animal> getAnimalsScientific(String scientificName) {
        return animalRepository.getAnimalsScientific(scientificName);
    }

    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());

        animalRepository.save(existing);
    }

    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
