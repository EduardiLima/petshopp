package br.com.tech4m.petshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4m.petshop.model.Pet;

public interface PetRepository extends MongoRepository<Pet, String> {
    
}
