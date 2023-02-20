package com.tian.dojos_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tian.dojos_ninjas.models.Dojo;
import com.tian.dojos_ninjas.repositories.DojoRepo;

@Service
public class DojoService {
    private final DojoRepo dojoRepo;
	
    public DojoService(DojoRepo dojoRepo) {
        this.dojoRepo = dojoRepo;
    }
    
    ;
	// create 
    public Dojo createDojo(Dojo newDojo) {
        return dojoRepo.save(newDojo);
    }
	
	// find one
    public Dojo oneDojo(Long id) { 
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    // get all 
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }

}
