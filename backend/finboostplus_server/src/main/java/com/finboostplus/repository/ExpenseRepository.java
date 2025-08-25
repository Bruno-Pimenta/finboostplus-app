package com.finboostplus.repository;

import com.finboostplus.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ExpenseRepository extends JpaRepository<Expense,Long> {


}
