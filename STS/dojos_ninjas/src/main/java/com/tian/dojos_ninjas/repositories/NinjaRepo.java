package com.tian.dojos_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tian.dojos_ninjas.models.Ninja;


@Repository
public interface NinjaRepo extends CrudRepository<Ninja,Long> {
    List<Ninja> findAll();

}
