package com.tian.dojos_ninjas.services;



import org.springframework.stereotype.Service;

import com.tian.dojos_ninjas.models.Ninja;
import com.tian.dojos_ninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
    private final NinjaRepo ninjaRepo;
	
    public NinjaService(NinjaRepo ninjaRepo) {
        this.ninjaRepo = ninjaRepo;
    }
    
    ;
	// create 
    public Ninja createNinja(Ninja newNinja) {
        return ninjaRepo.save(newNinja);
    }
	
}
