package com.tian.safe_travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tian.safe_travels.models.Expense;

@Repository//two tables, two repositories 
public interface ExpensesRepository extends CrudRepository<Expense,Long> {
    // this method retrieves all the books from the database
    List<Expense> findAll();


}
