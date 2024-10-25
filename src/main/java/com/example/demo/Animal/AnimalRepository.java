package com.example.demo.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);

    @Query(value = "SELECT * FROM Animals a WHERE a.species LIKE %?1%", nativeQuery = true)
    List<Animal> getAnimalsScientific(String scientificName);
}
