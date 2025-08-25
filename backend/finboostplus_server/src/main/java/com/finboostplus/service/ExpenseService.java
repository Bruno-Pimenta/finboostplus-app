package com.finboostplus.service;

import com.finboostplus.DTO.ExpenseRequestDTO;
import com.finboostplus.model.Category;
import com.finboostplus.model.Expense;
import com.finboostplus.model.Group;
import com.finboostplus.model.User;
import com.finboostplus.repository.ExpenseRepository;
import com.finboostplus.repository.GroupMemberRepository;
import com.finboostplus.repository.UserExpenseDivisionRepository;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    GroupMemberService groupMemberService;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    GroupService groupService;
   @Autowired
    UserExpenseDivisionRepository userExpenseDivisionRepository;
   @Autowired
   UserService userService;
   @Autowired
    GroupMemberRepository groupMemberRepository;
   @Autowired
   CategoryService categoryService;

    List<String> authLevels = List.of("OWNER", "ADMIN");

   public Expense addNewExpense(Long idGroup, Long idCategory, ExpenseRequestDTO expDto){

       Expense expense = new Expense();
       String userName = userService.authenticated();
       User user = userService.getUser(userName);
       Group group = groupService.getGroup(idGroup);
       Category category = categoryService.getCategory(idCategory);

       if(user != null){
           if(groupMemberService.getUserOnwerAdmin(user.getId(),idGroup,authLevels)
             && group != null){
               expense = expDto.expDToToExpense();
               expense.setGroup(group);
               expense.setCategory(category);

               return expenseRepository.save(expense);
           }
       }

    return null;

   }


}
